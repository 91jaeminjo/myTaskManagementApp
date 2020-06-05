# myTaskManagementApp

This is my full-stack application to manage tasks.

Users can create tasks with description, deadline, category, and deadline for the task and the app will store and display the data.

When the task has been completed, users can mark the tasks as complete, and if necessary, completed tasks can be marked as incomplete.

To run this project from source:

  - clone the repository

For back-end:
  - in the application.properties, setup the correct credential and ulr for datasource (spring.datasource.url, username, and password)
  - setup the proper port (server.port)
  - run the Java Spring application

For front-end:
  - navigate into the `myAppUI` directory
  - run 'npm install' to install the app's dependencies
  - Fix/customize the url to backend calls in the task.service.ts
  - run `ng serve` (options to specify host and port: example --host 0.0.0.0 --port 80) to run the front end Angular application
  - open `localhost:4200` (other host and port specified in the command above) from a web browser

The app is deployed in AWS. The link to the project can be found in my portfolio: 91jaeminjo.github.io/portfolio