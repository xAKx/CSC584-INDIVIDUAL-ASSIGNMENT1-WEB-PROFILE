**A little space to introduce yourself.**

This is a minimalist, mint-themed Personal Profile Web Application developed for **CSC584 – Individual Assignment 1**.

Built using HTML, CSS, Java Servlet, and JavaServer Pages (JSP), this project demonstrates how user information is collected, processed, and dynamically displayed through a Java web application.

## About the Project

Mintfolio aims to make a simple personal profile form feel more modern, clean, and enjoyable.

Users enter their personal details through an HTML form, submit them to a Java Servlet, and view their information on a dynamically generated JSP profile page.

The project focuses on simplicity, usability, and a soft mint-inspired interface.

## Features

**Core Features**
- Personal information form
- Student ID and programme details
- Email and hobbies input
- Short self-introduction
- Form submission using HTTP POST
- Servlet-based request processing
- Dynamic JSP profile display

**Design Goals**
- Soft mint and pastel color palette
- Clean, minimalist layout
- Responsive interface
- Rounded cards and input fields
- Simple, intuitive user experience

## Tech Stack

| Technology | Purpose |
|---|---|
| HTML5 | Page structure and input form |
| CSS3 | Styling and responsive layout |
| Java Servlet | Server-side form processing |
| JSP | Dynamic profile display |
| GlassFish 4.1.1 | Application server |
| Java EE 7 | Web application platform |
| NetBeans 8.2 | Development environment |
| Apache Ant | Project build system |

No external framework or database is required.

## How It Works

The application follows a simple request-response flow:

```text
        User
         |
         v
    index.html
   (Profile Form)
         |
         | HTTP POST
         v
 ProfileServlet.java
   (Process Data)
         |
         | Forward Request
         v
    profile.jsp
   (Display Profile)
```

## Project Structure

```text
PERSONAL WEB PROFILE/
├── web/
│   ├── index.html
│   ├── profile.jsp
│   ├── css/
│   │   └── style.css
│   └── WEB-INF/
│       └── glassfish-web.xml
├── src/
│   └── java/
│       └── com/
│           └── mintfolio/
│               └── controller/
│                   └── ProfileServlet.java
├── nbproject/
├── build.xml
└── README.md
```

*The structure above represents the intended project layout and may change during development.*

## Getting Started

### Prerequisites

- JDK compatible with NetBeans 8.2 and GlassFish 4.1.1 (Java 8 recommended)
- NetBeans IDE 8.2
- GlassFish Server 4.1.1
- Git (optional, for version control)

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/xAKx/CSC584-Mintfolio.git
   ```

2. Open NetBeans 8.2.
3. Select **File → Open Project**.
4. Navigate to the cloned project folder.
5. Configure **GlassFish Server 4.1.1** if necessary.
6. Right-click the project and select **Clean and Build**.
7. Right-click the project and select **Run**.
8. Open the application URL provided by NetBeans.

## Screenshots

Screenshots of the completed application will be added as development progresses.

- Profile information form
- Generated personal profile

## Assignment Information

| Item | Details |
|---|---|
| Course | CSC584 |
| Assignment | Individual Assignment 1 |
| Project | Personal Profile Web Application |
| Weightage | 10% |
| Deadline | 13 November 2026 |
| Development Environment | NetBeans 8.2 + GlassFish 4.1.1 |

## Development Status

🚧 **In Development**

The project is currently being developed as part of CSC584 Individual Assignment 1.

## Author

Developed by [@xAKx](https://github.com/xAKx)

---

*Made with Java, curiosity, and a little touch of mint.* 