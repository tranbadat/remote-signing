# 🌐 **Remote Signing**
**Secure, Scalable, and Customizable Solution for Digital Signatures**

1. [Getting Started](#getting-started)
2. [Project Overview](#project-overview)
3. [Goals](#goals)
4. [Core Features](#core-features)
5. [Tech Stack](#tech-stack)
6. [Learning Resources](#learning-resources)
7. [Contributions](#contributions)
8. [Contact](#contact)
9. [Show Your Support](#show-your-support)

---
## 📚 **How to Get Started**
See the [Getting Started Guide](docs/getting-started.md) for detailed instructions on setting up the project.
See the [System Design & Architecture](docs/System-design-architect.md) for an overview of the project's design.

---
<h2 id="project-overview">🚀 <b>Project Overview</b></h2>

[//]: # (## 📚 **Project Overview**)
The **Remote Signing** is an open-source project designed to demonstrate secure and efficient remote digital signature workflows. Whether you're developing a signing service for personal, enterprise, or multi-tenant use, this project serves as a reference implementation to accelerate your efforts.

---
<h2 id="goals">🚀 <b>Goals</b></h2>

[//]: # (## 🎯 **Goals**)
### **What does this project aim to achieve?**
- **Modular Design:** Build a highly adaptable framework for diverse signing use cases.
- **Top-Notch Security:** Ensure data integrity, secure hash validation, and compliance with PKCS7 standards.
- **Multi-Tenant & Multi-User Support:** Empower organizations with hierarchical, multi-user collaboration.
- **Extensibility:** Facilitate seamless integration with external APIs and authentication services.
- **Developer Learning:** Provide a clear, hands-on example for implementing deferred signing workflows.

---

<h2 id="core-features">🔑 <b>Core Features</b></h2>

[//]: # (## 🔑 **Core Features**)

- **Deferred Signing Workflow**
  - Hash generation and validation using PKCS7 standards.
  - Secure signature and certificate retrieval from signing providers.

- **Multi-Tenant Architecture**
  - Manage multiple organizations with tenant isolation.
  - Flexible support for user roles and permissions.

- **Distributed Locking**
  - Prevent conflicts in simultaneous signing requests using distributed locks.

- **Customizable Transaction IDs**
  - Format: `{tenant-id}-{batch_id}-{uuid}`.

- **Expiration-Based Document Sharing**
  - Share documents with anonymous users via expiring links.

---

<h2 id="tech-stack">🛠️ <b>Tech Stack</b></h2>

[//]: # (## 🛠️ **Tech Stack**)
The project is built using the following technologies:
- **Language:** Java 17
- **Framework:** Spring Boot
- **PDF Signing Library:** iText/PDFBox
- **Message Queue:** Kafka
- **Caching:** Redis Sentinel
- **Database:** PostgreSQL/MySQL
- **Distributed Locking:** Redisson
- **Authentication:** Keycloak
- **Storage:** MinIO/S3
- **Containerization:** Docker

---

<h2 id="learning-resources">📖 <b>Learning Resources</b></h2>

[//]: # (## 📖 **Learning Resources**)

Enhance your understanding with the following references:

- **PKCS7 Overview:** Learn about the Public Key Cryptography Standards [here](https://en.wikipedia.org/wiki/PKCS_7).
- **Spring Boot Documentation:** Explore the official Spring Boot framework [here](https://spring.io/projects/spring-boot).
- **iText Library:** Understand PDF manipulation and signing with iText [here](https://itextpdf.com/).
- **Redis Sentinel Documentation:** Learn about high availability with Redis [here](https://redis.io/docs/manual/sentinel/).
- **Kafka Documentation:** Dive into distributed messaging with Apache Kafka [here](https://kafka.apache.org/documentation/).

---

<h2 id="contributions">🤝 <b>Contributions</b></h2>

[//]: # (## 🤝 **Contributions**)

We welcome contributions to improve this project!

### How to Contribute:
1. **Fork this repository** to your GitHub account.
2. **Create a new branch** for your feature or bug fix:  
   `git checkout -b feature-name`
3. **Commit your changes** with a descriptive message:  
   `git commit -m "Add feature or fix issue"`
4. **Push your branch** to your GitHub fork:  
   `git push origin feature-name`
5. **Create a pull request** on the main repository.

---

<h2 id="contact">📬 <b>Contact</b></h2>

[//]: # (## 📬 **Contact**)

Have questions or feedback? Feel free to:
- Open an issue in this repository.
- Reach out via email: [contact@dattb.com](mailto:contact@dattb.com).

---

<h2 id="show-your-support">🌟 <b>Show Your Support</b></h2>

[//]: # (## 🌟 **Show Your Support**)
If you find this project helpful or insightful, please give it a ⭐ on GitHub!

---
