<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Vets Profile</title>
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

        h1 {
            color: #333333;
        }

        form {
            display: inline-block;
            margin: 10px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #3498db;
            color: white;
            padding: 15px 30px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h1>Edit Vets Profile</h1>

    <form action="ProcessVetsEditProfileServlet" method="post">
        <!-- Input fields for username, new id, new name, and new password -->
        <label for="username">Enter Your User Name:</label>
        <input type="text" name="username" required>

        <label for="newId">Enter New Id:</label>
        <input type="text" name="newId" required>
        
        <label for="newName">Enter New Name:</label>
        <input type="text" name="newName" required>

        <label for="newPassword">Enter New Password:</label>
        <input type="password" name="newPassword" required>

        <!-- Update button -->
        <button type="submit">Update Profile</button>
    </form>
</body>
</html>
