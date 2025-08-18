# OOP, Maven, and Developer Practices - Day 2

## Introduction to SDLC

The Software Development Life Cycle (SDLC) is a structured process that outlines the stages of software development. It is typically divided into 6 - 8 phases, which include: **Planning**, **Requirements**, **Design**, **Build**, **Document**, **Test**, **Deploy**, and **Maintain**. Some project managers will combine, split, or omit steps, depending on the project's scope. Understanding the SDLC is crucial for managing software projects effectively.

SDLC is a way to measure and improve the development process. It allows for a fine-grain analysis of each phase, helping teams identify bottlenecks, improve efficiency, and ensure high-quality deliverables.

As computing power increases, it places a higher demand on software and developers. Companies must reduce costs, deliver software faster, and meet or exceed customer expectations. SDLC helps achieve these goals by identifying inefficiencies and streamlining the development process.

### Real World Application

Organizations can use the SDLC process to provide structure when designing and building of applications.

This lifecycle approach provides an effective plan for various activities in software development such as designing, building (developing), and maintaining software applications. It also provides a methodology for enhancing the quality of software and the overall development process. Organizations can choose an effective software development strategy from a variety of SDLC models, such as **Waterfall**, **Agile**, or **DevOps**, depending on their specific needs and goals.

Various people in the organization can use the SDLC process such as software engineers, developers, and cross-function teams. Developers and software engineers use it to create effective plans and designs. They also apply the various SDLC stages to develop innovative software products. Cross-functional teams use the SDLC process to ensure that all aspects of software development are covered, from requirements gathering to testing and deployment.

**Importance of SDLC**

The software development life cycle adds value to software development in the following ways:

- It provides a structured approach to software development, ensuring that all aspects of the project are covered.
- It helps in effectively planning before starting the actual development. SDLC allows developers to analyze the requirements and design solutions that meet those needs.
- It helps in reducing unnecessary costs and build high-quality software. During the initial phases, developers can estimate the costs and predict costly mistakes.
- It enables developers to design and build high-quality software products that meet customer expectations. This is because they follow a systematic approach throughout the development process.
- It provides a basis when evaluating the effectiveness of the software. This further enhances the software product and the development process.

### Implementation

The following are general stages of the SDLC process. Depending on the scope of the project, some stages may be omitted, and other stages may be enhanced.

**Planning**

In the planning phase, the project's goals, scope, and feasibility are defined. This includes identifying stakeholders, gathering requirements, and creating a project plan that outlines the timeline, resources, and budget. The planning phase sets the foundation for the entire SDLC process, ensuring that all team members are aligned and working towards a common objective.

Project leaders evaluate the terms of the project, which includes calculating labor and material costs, creating a timetable with target goals, and creating the project's team and leadership structure.

Planning can also include feedback from stakeholders, including customers, end-users, and team members. This feedback is essential for refining requirements and ensuring that the project aligns with business objectives.

Stakeholders are individuals or groups who benefit from the project, including customers, users, and team members. Their input is crucial for understanding needs and expectations, which helps shape the project's direction.

Try to get feedback from potential customers, developers, subject matter experts, and sales reps.

Planning should clearly define the scope and purpose of the application. It plots the course and provisions the team to effectively create the software. It also sets boundaries to help manage expectations and prevent scope creep.

**Define Requirements**

In this stage, the team gathers and documents the functional and non-functional requirements of the application. This includes understanding user needs, business goals, and technical constraints. Requirements should be clear, measurable, and achievable, providing a solid foundation for the design and development phases.

Defining requirements is considered part of planning to determine what the application is supposed to do and its requirements. For example, a social media application would require the ability to connect with a friend. An inventory program might require a search feature.

Requirements also include defining the resources needed to build the project. For example, a team might develop software to control a custom manufacturing machine. The machine is a requirement for the software to function correctly, and the software must be able to control the machine.

**Design and Prototyping**

In this phase, the team creates the architecture and design of the application. This includes defining the overall structure, components, interfaces, and data flow. Prototyping may also be used to visualize and validate design concepts before full-scale development begins.

This phase models the way a software application will work. Some aspect of the design include:

- **Architecture**: Defines the overall structure of the application, including how components interact and communicate. Specifies the technologies and frameworks to be used, industry practices, overall design principles, and patterns.
- **User Interface**: Focuses on the layout, design, and user experience of the application. This includes creating wireframes, mockups, and prototypes to visualize the user interface and gather feedback from stakeholders.
- **Platforms**: Identifies the platforms (e.g., web, mobile, desktop) on which the application will run. This includes considerations for different operating systems, devices, and screen sizes, ensuring a consistent user experience across all platforms.
- **Programming**: Specifies the programming languages, frameworks, and tools to be used in the development process. This includes considerations for code quality, maintainability, and performance.
- **Communications**: Defines how different components of the application will communicate with each other, including APIs, messaging protocols, and data formats. This ensures seamless integration and data exchange between various parts of the system.
- **Security**: Addresses the security requirements and measures to protect the application and its data. This includes authentication, authorization, encryption, and compliance with industry standards and regulations.

Prototyping can be a part of the Design phase. A prototype is an early version of the application that demonstrates its functionality and design. It allows stakeholders to visualize the application and provide feedback before full-scale development begins. It is less expensive to change the prototype than to rewrite code to make a change in the Development phase.

**Software Development**

In this phase, the actual coding and implementation of the application take place. Developers write code based on the design specifications and requirements defined in the previous phases. This phase also includes unit testing to ensure that individual components function correctly.

A small project might be written by a single developer, while a large project might be broken up and worked on by several teams. Use an Access Control or Source Code Management (SCM) system to manage code changes and collaboration among team members. These systems help developers track changes, resolve conflicts, and maintain a history of the codebase. They also help ensure compatibility between different team projects and to make sure target goals are being met.

The coding process includes many other tasks. Many developers need to brush up on skills or work as a team. Finding and fixing errors and glitches is critical. Tasks often hold up the development process and require effective communication and collaboration among team members to resolve. SDLC can anticipate these delays so that developers can be tasked with other duties.

Software developers appreciate instructions and explanations. Documentation can be a formal process, including writing a user guide for the application. It can also be informal, like comments in the source code that explain why a developer used a certain procedure. Even companies that strive to create software that is easy and intuitive benefit from the documentation.

Documentation can be a quick guided tour of the application's basic functionality, helping users understand how to use it effectively. It can also include detailed technical specifications, API documentation, and troubleshooting guides to assist developers in maintaining and extending the application over time.

**Testing**

In this phase, the application is thoroughly tested to identify and fix any defects or issues. Testing can be divided into several levels, including unit testing, integration testing, system testing, and acceptance testing. Each level focuses on different aspects of the application and helps ensure that it meets the defined requirements and quality standards.

Testing is a critical part of the software development process, as it helps identify issues early and ensures that the application functions correctly before it is deployed to users. Automated testing tools and frameworks can be used to streamline the testing process and improve efficiency.

Specific testing can only be done in a specific environment - consider creating a simulated production environment for complex deployments. Testing should ensure that each function works correctly. Different parts of the application should also be tested to work seamlessly together - performance testing can help identify bottlenecks and ensure that the application can handle the expected load.

The testing phase helps to reduce bugs and improve the overall quality of the application. It also helps ensure that the application meets user expectations and provides a positive user experience.

**Deployment**

In the deployment phase, the application is released to the production environment and made available to users. This phase includes activities such as installation, configuration, and data migration. It is essential to ensure that the deployment process is smooth and minimizes downtime for users.

Many companies prefer to automate the deployment phase. this can as simple as displaying a payment portal and download link on the company website or using a cloud service to host the application. More complex deployments might require a team to install and configure the application on multiple servers.

Deployment can be complex, especially for large applications with many dependencies. It is essential to have a well-defined deployment plan that outlines the steps involved, including any necessary rollback procedures in case of issues.

**Operations and Maintenance**

At this point of the development cycle, the application is live and being used by customers. The operations and maintenance phase involves monitoring the application's performance, addressing any issues that arise, and making necessary updates and improvements.

In this phase, users discover bugs that were not found during testing, These errors need to be resolved, which can spawn new development cycles. Users may also request new features or enhancements, which require additional development work.

In addition to bug fixes, models like Iterative development plans for regular updates and improvements to the application. This can include adding new features, improving performance, and enhancing the user experience.

For each new release, a new SDLC cycle begins. This ensures that the application continues to evolve and meet the changing needs of users and the business.
