<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Make Appointment</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin: 10px 0;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
        }

        button {
            background-color: #3498db;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <form method="post" action="SaveAppointmentServlet">
        <label for="appointmentId">Appointment ID:</label>
        <input type="text" id="appointmentId" name="appointmentId" required>

        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required>

        <label for="appointmentDate">Appointment Date:</label>
        <input type="date" id="appointmentDate" name="appointmentDate" required>

        <button type="submit">Make Appointment</button>
    </form>
</body>
</html>
