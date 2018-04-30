# springboot-wire-mock
A Simple spring boot application to mock Rest Web Services

At times you need to mock your restful webservices in order to test scenarios outside your production environment.

You can achieve this creating a mock service of your api/services using 

* SOAP-UI Mock Services

* Json-Server

* WireMock, etc

In this example, lets see how to create standalone mock service using springboot application which will respond with a simulated reponse for 
the matching request elements

WireMock used JsonPath(Xpath for Json) to identify the elements in JSON, in this example also we have used the same


