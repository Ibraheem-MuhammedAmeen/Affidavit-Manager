/**
 * 
 */
 
 
    // Get the element to display the current date
    const currentDateSpan = document.getElementById('currentDate');

    // Function to get the current date in "18-Sep-2023" format
    function getCurrentDate() {
        const today = new Date();
        const day = String(today.getDate()).padStart(2, '0');
        const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        const month = monthNames[today.getMonth()];
        const year = today.getFullYear();
        const formattedDate = `${day}-${month}-${year}`;
        return formattedDate;
    }

    // Set the current date to the element
    currentDateSpan.textContent = getCurrentDate();

	
    // Get the element to display the current date
    const currentDateSpan = document.getElementById('currentDate');

    // Function to get the current date in "18-Sep-2023" format
    function getCurrentDate() {
        const today = new Date();
        const day = String(today.getDate()).padStart(2, '0');
        const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        const month = monthNames[today.getMonth()];
        const year = today.getFullYear();
        const formattedDate = `${day}-${month}-${year}`;
        return formattedDate;
    }

    // Set the current date to the element
    currentDateSpan.textContent = getCurrentDate();

    // Function to save form data to local storage
    function saveFormData() {
        const sentence1 = document.getElementById('sentence1').value;
        const sentence2 = document.getElementById('sentence2').value;
        const sentence3 = document.getElementById('sentence3').value;
        const sentence4 = document.getElementById('sentence4').value;
        const sentence5 = document.getElementById('sentence5').value;
        const sentence6 = document.getElementById('sentence6').value;
        const sentence7 = document.getElementById('sentence7').value;
        const sentence8 = document.getElementById('sentence8').value;
        const sentence9 = document.getElementById('sentence9').value;
        const sentence10 = document.getElementById('sentence10').value;
        const image = document.getElementById('imageInput').files[0];

        localStorage.setItem('sentence1', sentence1);
        localStorage.setItem('sentence2', sentence2);
        localStorage.setItem('sentence3', sentence3);
        localStorage.setItem('sentence4', sentence4);
        localStorage.setItem('sentence5', sentence5);
        localStorage.setItem('sentence6', sentence6);
        localStorage.setItem('sentence7', sentence7);
        localStorage.setItem('sentence8', sentence8);
        localStorage.setItem('sentence9', sentence9);
        localStorage.setItem('sentence10', sentence10);

        if (image) {
            const reader = new FileReader();
            reader.onload = function () {
                localStorage.setItem('image', reader.result);
            };
            reader.readAsDataURL(image);
        }
    }

    // Attach an event listener to the "Create" button to save the form data when clicked
    const createBtn = document.getElementById('saveBtn');
    createBtn.addEventListener('click', saveFormData);


