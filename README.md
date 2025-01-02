Quiz Microservice Applications (Back-end)
=========================================

<p>This project serves as a place to write and retrieve questions for the purpose of testing.</p>

![Short showcase of Evan's quiz microservive apps.](./quizapp-microservices-showcase.gif)

<h2>HOW IT WAS MADE</h2>

<p>It utilizes two primary applications, a question service and a quiz service, allowing for simpler maintenance and organization.</p>

<p>A service registry and an API gateway allow multiple instances of these applications to run simultaneously, making it scalable in a malleable way.</p>

<p>The project was built using Java's Spring Boot /w Maven, utilizing Spring's Web (REST) API and JPA (persistence API), as well as MySQL database connectivity.</p>

<p>The microservices function using Netflix's Eureka Server & Discoverable client, as well as Spring's Gateway and OpenFeign cloud routing client.</p>

<p>This back-end project built and bug-fixed completely by Evan.</p>
