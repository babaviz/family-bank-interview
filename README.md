# Interview Test
### Technology stack used
1. SpringBoot (java)
1. Maven
1. MySQL database
### How to run
1. Update the ```application properties``` file on the ```resources``` folder to suite your environment
1. Run ```mvn install``` to set up the project dependencies 
1. Run the main class ```SimpleRestServerApplication.java```, this should run smoothly if all dependencies are setup correctly
### Rest Server up and running?

##### Payment notification
* Endpoint [/api/v1/payment](/api/v1/payment)
* Type ```POST```
* Expects ```JSON```
* Sample request
    ```json
    {
        "reference":"WESDTRESFF",
        "channel":"channel",
        "paymentMethod":"AGENT",
        "amount":10000,
        "registrationNumber":"S13/20852/12"
    }
    ```
* Expected success Response
    ```json
      {
          "error": false,
          "message": "Payment received for S13/20852/12"
      }  
    ```
* Expected Error Response
    ```json
      {
          "error": true,
          "message": "Error Message"
      }  
    ```
  ```OR```
  ```Any other html response code other than 200```
  
  ### What happens
  > On receiving a payment notification, the system validates the registration number against the students' enrollment table, then retrieves the student's record to process notifications
  

  Enjoy :)
