document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'http://localhost:8080/api'; // Base URL for your backend API

    // Send SMS Button
    document.getElementById('send-sms-btn').addEventListener('click', () => {
        const messageContent = document.getElementById('send-message-content').value; // Get message content
        const recipients = document.getElementById('recipients').value; // Get recipients directly as a string

        const payload = {
            body: messageContent,
            recipients: recipients, // Use the string directly
        };

        // Make a POST request to send the SMS
        fetch(`${apiUrl}/message`, { // Ensure this matches your API endpoint
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            alert('SMS sent successfully!');
            console.log('Success:', data);
            
            // Clear the input fields after sending the message
            document.getElementById('send-message-content').value = ''; // Clear message content
            document.getElementById('recipients').value = ''; // Clear recipients

            fetchSmsHistory(); // Refresh SMS history after sending
        })
        .catch(error => console.error('Error:', error));
    });

    

    // Save Template Button (if needed)
    /* document.getElementById('save-template-btn').addEventListener('click', () => {
        const templateName = document.getElementById('template-name').value;
        const messageContent = document.getElementById('template-message-content').value; // Updated ID
        const associatedNumbers = document.getElementById('associated-numbers').value; // Use as a single string

        const payload = {
            templateName: templateName,
            body: messageContent,
            numbers: associatedNumbers, // Use as a single string
            messageDateTime: new Date().toISOString() // Optional for templates
        };

        // Make a POST request to save the template
        fetch(`${apiUrl}/save-template`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload)
        })
        .then(response => response.json())
        .then(data => {
            alert('Template saved successfully!');
            console.log('Success:', data);
            
             // Clear the input fields after saving the template
             document.getElementById('template-name').value = ''; 
             document.getElementById('template-message-content').value = ''; 
             document.getElementById('associated-numbers').value = '';

             fetchTemplates(); // Optionally refresh the template list
        })
        .catch(error => console.error('Error:', error));
    }); */

    // Function to fetch SMS history and display it
    function fetchSmsHistory() {
        fetch(`${apiUrl}/messages`) // Ensure this matches your API endpoint for fetching messages
            .then(response => response.json())
            .then(data => {
                const smsHistoryBody = document.getElementById('sms-history-body');
                smsHistoryBody.innerHTML = ''; // Clear existing entries

                data.forEach(entry => {
                    const row = `
                        <tr>
                            <td class="border px-4 py-2">${entry.messageDateTime}</td>
                            <td class="border px-4 py-2">${entry.body}</td>
                            <td class="border px-4 py-2">${entry.recipients}</td> <!-- Display recipients -->
                            <td class="border px-4 py-2 space-x-2">
                                <button class="bg-blue-600 text-white px-3 py-1 rounded-md hover:bg-blue-700" onclick="resendSms('${entry.messageId}')">Resend</button>
                                <button class="bg-yellow-600 text-white px-3 py-1 rounded-md hover:bg-yellow-700" onclick="editSms('${entry.messageId}')">Edit</button>
                            </td>
                        </tr>`;
                    smsHistoryBody.insertAdjacentHTML('beforeend', row);
                });
            })
            .catch(error => console.error('Error fetching SMS history:', error));
    }

    // Function to resend an SMS
    window.resendSms = function(id) {
        fetch(`${apiUrl}/resend-sms/${id}`, { method: 'POST' })
            .then(response => response.json())
            .then(data => {
                alert('SMS resent successfully!');
                console.log('Resend Success:', data);
                fetchSmsHistory(); // Refresh history after resending
            })
            .catch(error => console.error('Error resending SMS:', error));
    };

    // Function to edit an SMS
    window.editSms = function(id) {
        // Fetch the existing message details
        fetch(`${apiUrl}/message/${id}`) // Assuming you have an endpoint to get a single message by ID
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(message => {
                // Populate the modal with existing message details
                document.getElementById('edit-message-content').value = message.body;
                document.getElementById('edit-recipients').value = message.recipients;

                // Show the modal
                document.getElementById('edit-sms-modal').classList.remove('hidden');

                // Add event listener for saving changes
                document.getElementById('save-edited-sms-btn').onclick = function() {
                    const updatedPayload = {
                        body: document.getElementById('edit-message-content').value,
                        recipients: document.getElementById('edit-recipients').value,
                    };

                    // Send updated message back to server
                    fetch(`${apiUrl}/messages/${id}`, { // Assuming you have a PUT endpoint to update a message
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(updatedPayload)
                    })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                        return response.json();
                    })
                    .then(data => {
                        alert('SMS updated successfully!');
                        console.log('Update Success:', data);
                        fetchSmsHistory(); // Refresh history after updating
                        document.getElementById('edit-sms-modal').classList.add('hidden'); // Hide modal
                    })
                    .catch(error => console.error('Error updating SMS:', error));
                };

                // Add event listener for canceling edit
                document.getElementById('cancel-edit-btn').onclick = function() {
                    document.getElementById('edit-sms-modal').classList.add('hidden'); // Hide modal
                };
            })
            .catch(error => console.error('Error fetching SMS details:', error));
    };

    // Fetch initial SMS history on page load
    fetchSmsHistory();
});