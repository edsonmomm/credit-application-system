<h1>credit-application-system</h1>
<p style="text-align: center">Rest API for a Credit Valuation System</p>
<p style="text-align: center">
    <img src="https://img.shields.io/badge/Java-v17-blue.svg" alt="Java"/>
    <img src="https://img.shields.io/badge/Kotlin-v1.7.22-purple.svg" alt="Kotlin"/>
    <img src="https://img.shields.io/badge/Spring%20Boot-v3.0.3-brightgreen.svg" alt="Spring Boot"/>
    <img src="https://img.shields.io/badge/Gradle-v7.6-lightgreen.svg" alt="Gradle"/>
    <img src="https://img.shields.io/badge/H2-v2.1.214-darkblue.svg" alt="H2"/>
    <img src="https://img.shields.io/badge/Flyway-v9.5.1-red.svg" alt="Flyway">
</p>

<h3>Project Description</h3>
<p>This project was started as a case study in the Kotlin bootcamp at <a href="https://www.dio.me/"> DIO</a>.
   <br>
   A finance company needs to create a credit application analysis system.
   <br>
   This REST API, build in Kotlin with Spring Boot, will provide the following functionalities:
</p>

<ul>
    <li><h3>Customer:</h3>
        <ul>
            <li><strong>Create (register):</strong>
                 <ol>
                    <li><strong>Request: </strong><em>firstName, lastName, cpf, income, email, password, zipCode e street</em></li>
                    <li><strong>Response: </strong>JSON with <em>firstName, lastName, income, cpf, email, income, zipCode, street</em></li>
                </ol>
            </li>
            <li><strong>Update (edit registration):</strong>
            <ol>
              <li><strong>Request: </strong><em>id, firstName, lastName, income, zipCode, street</em></li>
              <li><strong>Response: </strong>JSON with <em>firstName, lastName, income, cpf, email, income, zipCode, street</em></li>
            </ol>
            </li>  
            <li><strong>Visualize:</strong>
                <ol>
                  <li><strong>Request: </strong> <em>id</em></li>
                  <li><strong>Response: </strong>JSON with <em>firstName, lastName, income, cpf, email, income, zipCode, street</em></li>
                </ol> 
            </li>
            <li><strong>Delete registration:</strong>
                <ol>
                  <li><strong>Request: </strong><em>id</em></li>
                  <li><strong>Response: </strong><em>no return</em></li>
                </ol>
            </li>
        </ul>
    </li>
    <li><h3>Request a Loan (Credit):</h3>
        <ul>
            <li><strong>Create (register):</strong>
                <ol>
                    <li><strong>Request: </strong><em>creditValue, dayFirstOfInstallment, numberOfInstallments e customerId</em></li>
                    <li><strong>Response: </strong>JSON with <em>creditCode, creditValue, numberOfInstallment</em></li>
                </ol>
            </li>
            <li><strong>List all credit requests from a customer:</strong>
                <ol>
                  <li><strong>Request: </strong><em>customerId</em></li>
                  <li><strong>Response: </strong>JSON with <em>creditCode, creditValue, numberOfInstallment</em></li>
                </ol> 
            </li>
        </ul>
        <ul><strong>Visualize a credit:</strong>
            <ol>
              <li><strong>Request: </strong><em>customerId e creditCode</em></li>
              <li><strong>Response: </strong>JSON with <em>creditCode, creditValue, numberOfInstallment, status, emailCustomer e incomeCustomer</em></li>
            </ol>
        </ul>        
    </li>
</ul>

<figure>
    <p style="text-align: center">
      <img src="https://i.imgur.com/vWT4aez.png" height="450" width="650" alt="API para Sistema de Avaliação de Créditos"/><br>
      Simplified UML Diagram of an API for a Credit Valuation System
    </p>
</figure>
<figure>
    <p style="text-align: center">
      <img src="https://i.imgur.com/SwMC6sq.png" height="350" width="600" alt="Arquitetura em 3 camadas Projeto Spring Boot"/><br>
      3-tier architecture Spring Boot Project
    </p>
</figure>

<h6>* The file [cas.postman_collection.json](src/main/resources/cas.postman_collection.json) may help to test the endpoints using Postman tool.</h6>
<h6>** To ease the demonstration of this application, it is recommended to use IntelliJ IDEA and run the project through the IDE.</h6>