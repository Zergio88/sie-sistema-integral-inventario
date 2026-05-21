# sie-sistema-integral-inventario

# Warehouse Inventory System API

> Deployed with Docker on Render, connected to a managed PostgreSQL instance on Supabase.

---

## Overview

This project is the redesign of an inventory system I originally developed in 2023 and successfully used in a real warehouse environment to register notebooks and other IT devices.

The first version achieved its main objective and allowed the inventory process to be completed successfully. However, it was developed under strict time constraints and with a simplified database design, which introduced limitations when new business requirements emerged.

This new version aims to rebuild the system using modern technologies, clean architecture, and software engineering best practices in order to deliver a maintainable, scalable, and well-documented backend application.

The system allows users to:

* Register products and IT assets.
* Manage warehouses, pallets, and physical locations.
* Perform inventory operations through barcode scanning.
* Track item movements and audit history.
* Export inventory results to Excel.
* Authenticate users and authorize actions using role-based access control.

This repository contains the backend API only. A frontend application will be developed separately.

---

## Business Problem

Companies that manage large numbers of IT assets need a reliable way to:

* Identify each device.
* Record its physical location.
* Track inventory discrepancies.
* Export data in formats compatible with business reporting tools.
* Maintain a complete audit trail of movements.

In the original project, inventory data had to be exported into a pre-existing Excel template, which led to a denormalized database structure optimized for immediate delivery rather than long-term maintainability.

This version solves the same business problem with a normalized data model and a more robust architecture.

---

## Project History

### Version 1 – 2023

**Technology stack:** Java, Swing, SQL Server.

Features:

* Desktop application installed on multiple computers.
* REST API running locally.
* Barcode-based inventory registration.
* Excel export integrated with an existing reporting spreadsheet.

Lessons learned:

* Requirements evolved after the initial implementation.
* The database structure was heavily coupled to the Excel output format.
* The application fulfilled its operational goal but was difficult to extend.

### Version 2 – Current

This version is a complete redesign focused on:

* RESTful API built as a well-structured monolith with a layered architecture
  (Controller → Service → Repository).
* Clean code and SOLID principles.
* Automated testing.
* Containerization.
* Cloud deployment.
* Security with JWT and role-based authorization.

---

## Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven

### Testing

* JUnit 5
* Mockito
* Testcontainers
* JaCoCo

### Documentation

* OpenAPI / Swagger

### DevOps

* Docker
* Docker Compose
* GitHub Actions (CI)
* Codecov (coverage reporting)
* Render (deployment)
* Supabase (managed PostgreSQL)

### Monitoring

* Spring Boot Actuator
*
---

## Planned Features

* Product management.
* Warehouse and location management.
* Pallet tracking.
* Barcode scanning endpoint.
* Inventory sessions.
* Movement history.
* Excel export.
* Authentication and authorization.
* Audit logging.

---

## Roles

### Administrator

* Manage users.
* Configure warehouses and locations.
* Access all reports.
* Export inventory data.

### Operator

* Scan devices.
* Update inventory records.
* View assigned inventory data.

---

## Architecture Goals

This project is designed with the following objectives:

* Clear separation of concerns.
* Maintainable and readable code.
* Comprehensive automated tests.
* Production-ready deployment.
* Well-documented API.

---

## Testing Strategy

The project includes:

* Unit tests for services and business logic using Mockito.
* Integration tests using Testcontainers with a real PostgreSQL instance.
* Code coverage reports generated with JaCoCo and published via Codecov.
* CI pipeline configured with GitHub Actions to run all tests on every push.

---

## Deployment

The application will be deployed using:

* Render for hosting.
* Supabase for PostgreSQL.
* Docker containers.

---

## Future Improvements

* Frontend application (React or Angular).

---

## Key Lessons Learned

This project reflects several important lessons from real-world software development:

* Delivering a working solution is important, but maintainability matters.
* Requirements often evolve after deployment.
* Database design should reflect business concepts rather than reporting formats.
* Refactoring and redesign are essential professional skills.

---

## Author

Developed by Sergio Mamani as part of the Talento Tech backend
program final project, and as a professional portfolio piece
focused on Java and Spring Boot.