<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <section class="row">
        <div class="col-md-12">

            <div class="header-color p-4">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 text-center text-white">
                        <h5>HIGHT COURT OF JUSTICE</h5>
                        <p>FEDERAL CAPITAL TERRITORY, ABUJA</p>
                    </div>
                    <div class="col-md-3">
						 <button class="btn btn-success" onclick="goBack()">Go Back to Previous Page</button>
                    </div>
                </div>
            </div>
            <div class="after-Header p-2"></div>
        </div>
    </section>
    <section class="my-5 container">

        <form method="post" action="addimagessss" id="uploadForm" enctype="multipart/form-data">

            <label for="imageInput">Select an image:</label>
            <input type="file" id="imageInput" accept="image/*" class="my-2" name="image" /><br>
            <label for="sentence1">I</label>
            <input type="text" placeholder="Name" style="width: 50%;" class="my-2" name="name" id="sentence1"
                required>
            <label for="sentence2">Of</label><br>
            <input type="text" placeholder="25 DURBAN STREET" class="my-2" id="sentence2" name="street" required>
            <label for="">Make Oaths and say</label><br>
            <label for="sentence3">That</label>
            <input type="text" class="form-control"
                placeholder="I AM THE ABOVE NAMED PERSON AND THE DEPONENT HEREIN, I AM THE SPONSOR OF ABDULLAHI FADEELAH HAMZA WITH PASSPORT NUMBER A11256025"
                id="sentence3" name="describe1" required>
            <label for="sentence4">That</label>
            <input type="text" class="form-control" id="sentence4" name="describe2"
                placeholder="ABDULLAHI FADEELAH HAMZA HAS GAINED ADMISSION INTO UNIVERSITY OF BRADFORD FOR MSC MARKETING AND MANAGEMENT"
                required>
            <label for="sentence5">That</label>
            <input type="text" class="form-control" name="describe3" id="sentence5"
                placeholder="IN VIEW OF THE ABOVE, I SHALL BE RESPONSIBLE FOR HER TUITION, ACCOMODATION, TRANSPORTATION, FEEDING, AND ANY OTHER EXPENSE SHE MIGHT INCURE IN HER STUDIES"
                required>
            <label for="sentence6">That</label>
            <input type="text" class="form-control" id="sentence6" name="describe4"
                placeholder="INCASE OF ANY EMERGENCY, I SHALL BE ABLE FOR HER REPARTRIATION" required>
            <label for="sentence7">That</label>
            <input type="text" class="form-control" id="sentence7" name="describe5"
                placeholder="I DEPOSE TO THIS AFFIDAVIT IN GOOD FAITH AND FOR RECORD PURPOSES" required>
            <label for="sentence8">That</label>
            <input type="text" class="form-control" id="sentence8" name="describe6"
                placeholder="NO DIRECTOR OF COMPANY NAME IS OR WAS OFFICER OR BOARD MEMBER OF THE MINISTRY OF PETROLEUM RESOURCES"
                required>
            <label for="sentence9">That</label>
            <input type="text" class="form-control" id="sentence9" name="describe7"
                placeholder="THE COMPANY DOES NOT AT THE TIME OF THIS BID HAVE ANY EXISTING LOAN OR FINACIAL STABILITY WITH A BANK, OTHER FINACIAL INSTITUTIONS OR THIRD PARTY CLASSIFIED AS DOUBTFUL, BAD OR NON PERFORMING">
            <p>That I am making this solemn declaration consciently believing same to be true and correct in accordance
                with the Oaths Act of 1990.</p>

            <div class="row">
                <div class="col-md-6 align-self-center">
                    <p style="float: left;">Date: <span id="currentDateSpan" class="my-2"></span></p>
                </div>
                <div class="col-md-6">
                    <p>DEPONENT</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <label for="">Sworn to at the</label>
                    <input type="text" id="sentence10" name="registry"> Registry<br>
                </div>
            </div>

            <button type="submit" value="Submit" class="my-2" id="saveBtn">Create</button>
        </form>
    </section>

    <script>
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

        // Set the current date to the element with id "currentDateSpan"
        document.getElementById('currentDateSpan').textContent = getCurrentDate();
    </script>
</body>

</html>
