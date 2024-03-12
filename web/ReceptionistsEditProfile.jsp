<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        h1 {
            color: #333333;
        }

        form {
            display: inline-block;
            margin: 10px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333333;
        }

        input {
            padding: 10px;
            margin-bottom: 15px;
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #ffffff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h1>Edit Your Profile</h1>

    <form action="ProcessReceptionistsEditProfileServlet" method="post">
        <!-- Input fields for editing profile -->
        <label for="username">Enter Your User Name:</label>
        <input type="text" name="username" required><br>
        
        <label for="newId">Enter New Id:</label>
        <input type="text" name="newId" required><br>

        <label for="newName">Enter New Name:</label>
        <input type="text" name="newName" required><br>

        <label for="newPassword">Enter New Password:</label>
        <input type="password" name="newPassword" required><br>

        <!-- Submit button for profile update -->
        <input type="submit" value="Update Profile">
    </form>
</body>
</html>
