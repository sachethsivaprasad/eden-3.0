<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Information</title>
    <style>
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Employee Information</h1>
    <table id="employeeTable">
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Date of Joining</th>
                <th>Contact Number</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <script>
        // Function to fetch JSON data from the endpoint
        async function fetchData() {
            try {
                const response = await fetch('http://localhost:8080/company/employees');
                const data = await response.json();
                return data;
            } catch (error) {
                console.error('Error fetching data:', error);
                return [];
            }
        }

        // Function to display JSON data in table
        async function displayData() {
            var tableBody = document.querySelector("#employeeTable tbody");
            var jsonData = await fetchData();
            jsonData.forEach(function(employee) {
                var row = document.createElement("tr");
                row.innerHTML = "<td>" + employee.employeeId + "</td>" +
                                "<td>" + employee.name + "</td>" +
                                "<td>" + employee.email + "</td>" +
                                "<td>" + employee.dateOfJoining + "</td>" +
                                "<td>" + employee.contactNumber + "</td>";
                tableBody.appendChild(row);
            });
        }

        // Call the function to display data
        displayData();
    </script>
</body>
</html>
