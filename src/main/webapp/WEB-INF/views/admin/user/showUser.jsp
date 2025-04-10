<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>User Detail ${id}</title>
            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <link rel="stylesheet" href="/css/demo.css">
        </head>

        <body>
            <div class="container mt-5">
                <div class="row">
                    <div class="col-md-12 col-12 mx-auto">
                        <div class="d-flex justify-content-between">
                            <h2>User Datail With id=${user_by_id.get().getId()}</h2>
                        </div>
                        <div class="card">
                            <div class=" card-header">
                                User information
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Full Name : ${user_by_id.get().getFullname()}</li>
                                <li class="list-group-item">Email: ${user_by_id.get().getEmail()}</li>
                                <li class="list-group-item">Password: ${user_by_id.get().getPassword()}</li>
                                <li class="list-group-item">Address: ${user_by_id.get().getAddress()}</li>
                                <li class="list-group-item">Phone: ${user_by_id.get().getPhone()}</li>
                            </ul>
                        </div>


                    </div>
                </div>
            </div>


        </body>

        </html>