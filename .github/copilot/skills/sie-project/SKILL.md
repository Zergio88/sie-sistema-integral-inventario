---
name: sie-project
description: Technical context, data model and conventions for the SIE warehouse inventory system. Use this when working on any feature of this project.
---

# SIE - Technical Project Context

## Stack
- Java 21, 
- Spring Boot 4.0.6
- PostgreSQL 17.6 (Supabase free plan)
- Flyway 11.14.1
- Spring Security 7.0.5 + JWT (pending)
- Hibernate 7.2.12.Final
- JUnit Jupiter 6.0.3 + Mockito 5.20.0 (already included via test starter)
- Maven

## Known Infrastructure Quirks
- Supabase free plan requires session pooler for IPv4 connectivity
- FlywayConfig.java configured manually, spring.flyway.enabled=false to avoid conflict
- spring.jpa.hibernate.ddl-auto=validate (Flyway owns schema, not Hibernate)

## Package Structure
- config/ → FlywayConfig, SecurityConfig
- entity/ → JPA entities
- repository/ → JpaRepository interfaces
- service/impl/ → business logic
- controller/ → REST endpoints
- dto/request/ and dto/response/ → never expose entities directly
- exception/ → @RestControllerAdvice

## Database Migrations
- Location: src/main/resources/db/migration/
- V1: zone, location, pallet, device_type, device, serial_number, spare_lot
- V2: users + created_by/updated_by on device and spare_lot
- Never modify existing migration files

## Data Model
- device → main entity, always has pallet_id + floor_number
- device_type → product catalog
- serial_number → separate table, N per device, field named 'primary' with isPrimary() getter
- spare_lot → spare parts without serial, tracked by quantity
- users → table name 'users' (reserved word), role: ADMIN or OPERATOR
- Hierarchy: zone → location → pallet → device

## JPA Conventions
- IDs: Integer with GenerationType.IDENTITY
- Timestamps: LocalDateTime in Java
- Relations: @ManyToOne with full object, never raw FK integer field
- Zone and Location have no timestamps

## Security
- BCryptPasswordEncoder bean in SecurityConfig
- UserServiceImpl hashes password before saving
- JWT pending implementation

## Project Phases
- Phase 1 DONE → Core schema + JPA entities
- Phase 2 DONE → Users + traceability
- Phase 3 IN PROGRESS → Repositories + Services + REST endpoints
- Phase 4 PENDING → Spring Security + JWT
- Phase 5 PENDING → Stocktaking
- Phase 6 PENDING → Reports and metrics

## Conventions
- Constructor injection always, never @Autowired on fields
- DTOs separate from entities in all layers
- updated_at managed by Spring Boot @LastModifiedDate
- Status fields: VARCHAR in DB, enum in Java
- Commits: feat/fix/chore/refactor/test prefix