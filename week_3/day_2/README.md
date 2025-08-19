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

## Agile Methodology

The **Agile** model is a popular approach to software development that emphasizes flexibility, collaboration, and customer feedback. It is based on the Agile Manifesto, which values individuals and interactions, working software, customer collaboration, and responding to change over following a strict plan.

It was designed by developers to put customer needs first and to create software that is easy to change. Agile development is iterative and incremental, allowing teams to deliver small, functional pieces of software quickly and continuously improve based on user feedback.

This method focuses strongly on user experience and input. Plus, it makes the software highly responsive to customer feedback. Agile seeks to release software cycles quickly, to respond to a changing market. This requires a strong team with excellent communication. However, if not implemented correctly, Agile can lead to chaos and confusion.

**Advantages**

- Flexibility: Agile allows for changes in requirements and priorities, making it easier to adapt to evolving customer needs.
- Faster Delivery: Agile teams can deliver working software in shorter cycles, providing value to customers more quickly.
- Improved Collaboration: Agile promotes collaboration between developers, stakeholders, and customers, leading to better communication and alignment on project goals.
- When compared to the waterfall model, Agile has a reduced scope which results in better time allocation and estimation.

**Disadvantages**

- The final product depends on the customer's involvement and feedback, which may not always be available or consistent. If the customer is not clear on what is needed, the development team may struggle to deliver the right solution.
- Requires a strong team with excellent communication skills. If team members are not able to collaborate effectively, it can lead to confusion and delays.
- If not implemented properly, it could lead to inadequate documentation which hinders future development and maintenance.

**Actors**

**Actors** are individuals or groups who have a vested interest in the outcome of a project. In the context of Agile development, there are three main roles or "actors":

- Product owner
- Scrum master
- Development team

Understanding the roles and perspectives of these actors is essential for successful Agile development.

**Product Owner**

The **Product Owner** is responsible for defining the product vision and prioritizing features based on customer needs. They act as a liaison between the stakeholders and the development team, ensuring that the team is working on the most valuable features first. The Product Owner is also responsible for maintaining the product backlog, which is a prioritized list of features, enhancements, and bug fixes.

- Responsible for maximizing the value of the product and the work of the development team.
- Manages the product backlog, ensuring that it is prioritized and refined.
- Defines and prioritizes user stories based on customer needs and business goals.
- Acts as the voice of the customer, ensuring that the development team understands the requirements and expectations.

**Scrum Master**

The **Scrum Master** is responsible for facilitating the Agile process and ensuring that the development team follows Agile principles and practices. They help remove obstacles that may impede the team's progress and ensure that the team is working effectively. The Scrum Master also acts as a coach, helping the team improve their processes and practices over time.

- Facilitates the Scrum process, which is a specific Agile framework.
- Removes impediments that may hinder the team's progress.
- Ensures Scrum practices are followed and helps the team improve their processes.
- Coaches the team in self-organization and cross-functionality.

**Development Team**

The **Development Team** is responsible for delivering high-quality software increments in each iteration. They work collaboratively to design, develop, test, and deploy the product features defined in the product backlog. The Development Team is self-organizing and cross-functional, meaning they have all the skills necessary to complete the work without relying on external resources.

- Cross-functional group responsible for delivering the product increments.
- Self-organizing team that manages its own work and processes.
- Typically includes designers, developers, and testers.
- Works collaboratively to deliver sprint goals and product increments.
- Participates in sprint planning, daily stand-ups, sprint reviews, and retrospectives.

These roles work together to ensure efficient and effective product development. The Product Owner defines the vision and priorities, the Scrum Master facilitates the process, and the Development Team delivers the product increments.

### Real World Application

Below is a short list of companies that use Agile development:

**Philips**

Philips is one firm that has adopted Agile principles. After numerous changes to management structure, the firm introduced several Agile coaches that went to deploy Scrum principles such as Scrum boards and breaking down teams into smaller ones. As a result of changes like this, teams could react to situations quicker, bureaucracy was removed, and it was ultimately easier for these smaller teams to take responsibility for their respective products.

**VistaPrint**

VistaPrint is the go-to marketing company for small businesses. The company performed some analysis of their existing waterfall methodology and found that teams were taking more than 60 days to move from the “ideation phase” to product delivery. The 60-day cycle only amounted to 40 hours of actual work.

The company looked further into why this was the case. They discovered that some of their processes were resulting in unusually large project lead times.

VistaPrint decided to switch to Agile practices with a focus on decreasing project lead time. VistaPrint was able to optimize their business processes and saw their Lead Time decrease from 40 days down to 15.

### Implementation

The Agile Manifesto outlines 4 Core Values and 12 Guiding Principles which serve as a North Star for any team adopting an Agile methodology.

The 4 Core Values of Agile are:

1. **Individuals and interactions over processes and tools**: Emphasizes the importance of people and communication in the development process.

- As sophisticated as technology gets, the human element remains crucial for successful collaboration and innovation.
- Relying too heavily on processes and tools results in an inability to adapt to changing circumstances.

2. **Working software over comprehensive documentation**: Prioritizes delivering functional software that meets user needs rather than extensive documentation.

- As important as documentation is, working software is more valuable because it provides immediate feedback and allows for quicker iterations. This value is about giving the developers exactly what they need to get the job done, without overloading them with unnecessary paperwork.

3. **Customer collaboration over contract negotiation**: Focuses on working closely with customers to understand their needs and deliver value, rather than strictly adhering to contract terms.

- Your customers are one of your most powerful assets.
- Engaging with customers throughout the development process leads to better outcomes and higher satisfaction.
- Flexibility and adaptability are key to responding to changing customer requirements.

4. **Responding to change over following a plan**: Encourages teams to be flexible and adapt to changes in requirements or market conditions, rather than rigidly sticking to a predefined plan.

- This value is one of the biggest departures from traditional project management approaches.
- Historically, projects were planned in detail upfront, and any changes were seen as disruptions as well as seen as an expense.
- Agile allows for continuous adaptation and improvement throughout the project lifecycle. Each sprint provides an opportunity for teams to reflect on their progress and make adjustments as needed.

**Key Components of Agile Project Management**

**User Stories**

User stories are short, simple descriptions of a feature or functionality from
the perspective of the end-user. They typically follow a specific format: "As a [type of user], I want [an action] so that [a benefit/a value]." User stories help teams understand the user's needs and prioritize features based on their value to the customer.

- A user story is a high-level definition of a work requirement.
- It contains just enough information so the team can produce a reasonable estimate of the effort required to implement the feature.
- This short and concise format is written from the user's perspective and focuses on outlining what your client wants (their goals) and why.
- The user story follows the general format: "As a [type of user], I want [an action] so that [a benefit/a value]."
- Example: As a manager, I want to be able to understand my team's progress so that I can make informed decisions.

**Sprints**

Sprints are time-boxed iterations, typically lasting 1-4 weeks, during which a specific set of user stories or features is developed and delivered. Sprints provide a structured framework for teams to plan, execute, and review their work, allowing for regular feedback and continuous improvement.

- Sprints are a short iteration, usually between one to three weeks to complete, where teams work on tasks determined in the sprint planning meeting.
- Sprints begin with a planning meeting, where the team selects user stories from the product backlog to work on during the sprint.
- As you move forward, the idea is to have a potentially shippable product at the end of each sprint.
- Daily stand-up meetings are held to discuss progress, identify obstacles, and make any necessary adjustments.
- At the end of the sprint, a review meeting is conducted to demonstrate the completed work to stakeholders and gather feedback. You review the product and see what is and isn't working, make adjustments as needed and begin another sprint to improve the product or service.
- A retrospective meeting follows to reflect on the sprint process and identify areas for improvement.
- Sprints are implemented in the Agile framework Scrum but not in some other Agile frameworks such as Kanban.

**Stand-up Meetings**

Stand-up meetings, also known as daily scrums, are short, focused meetings held at the same time each day. During these meetings, team members share updates on their progress, discuss any challenges they are facing, and plan their work for the day. Stand-up meetings promote transparency, accountability, and collaboration within the team.

- These meetings are typically time-boxed to 15 minutes and are held in a standing position to encourage brevity and focus.
- Team members answer three key questions: What did I accomplish yesterday? What do I plan to work on today? Are there any blockers or challenges I need help with?
- Stand-up meetings help identify and address issues early, keeping the team aligned and on track.
- They also foster a sense of camaraderie and shared purpose among team members.

**Agile Board**

An Agile board is a visual management tool that helps teams track their work and progress throughout the sprint. It typically consists of columns representing different stages of the workflow (e.g., "To Do," "In Progress," "Done") and cards representing individual user stories or tasks. Agile boards can be physical (e.g., a whiteboard with sticky notes) or digital (e.g., using project management software).

- Agile boards promote transparency by providing a clear view of the team's work and progress.
- They facilitate collaboration by allowing team members to easily see what others are working on and identify any dependencies or blockers.
- Agile boards are often used in conjunction with daily stand-up meetings to help teams stay aligned and focused on their goals.
- This can be a whiteboard with stick notes, a simple KanBan board, or a function within your project management software.

**Backlog**

The backlog is a prioritized list of work items, user stories, or features that need to be developed. It serves as the single source of truth for the team's work and is continuously refined and updated throughout the project.

- The backlog is typically managed by the product owner, who is responsible for prioritizing items based on business value, user needs, and feedback.
- Items in the backlog can be added, removed, or re-prioritized as needed, ensuring that the team is always working on the most important tasks.
- The backlog is often divided into different sections, such as "To Do," "In Progress," and "Done," to help visualize the team's progress.
- During sprint planning meetings, the team selects items from the backlog to work on during the upcoming sprint.
- As project requests are added through your intake system, they become outstanding stories in the backlog.
- During Agile planning sessions, your team will estimate the effort required also known as story points for each item in the backlog.
- The team will then prioritize the backlog based on factors such as business value, user needs, and technical dependencies.
- During sprint planning, stories in the backlog are moved into the sprint to be completed during the iteration.
- Managing your backlog is a vital role for project managers in an Agile environment.

**What are Steps in the Agile Methodology?**

The goal of Agile is to produce shorter development cycles and more frequent product releases than traditional waterfall project management. This shorter time frame enables project teams to react to changes in the client's needs more effectively.

You can use a few different Agile frameworks, such as Scrum, Kanban, or Lean, depending on your team's needs and the nature of the project.

Each framework implements Agile principles in different ways, but they all share the same core values and principles outlined in the Agile Manifesto.

For example, Kanban teams use visuals to manage work in progress, while Scrum teams use time-boxed sprints to deliver increments of work.

However, each Agile methodology typically follows these general steps:

- **Project Planning**: Define the project vision, goals, and objectives. Identify stakeholders and gather initial requirements.
  - Like with any project, before beginning your team should understand the end goal, the value to the organization or client, and how it will be achieved.
  - You can develop a project scope here, but remember that the purpose of using Agile is to be flexible and adapt to changes, so the project scope should not be seen as fixed.
- **Product Roadmap Creation**: Develop a high-level timeline for the project, outlining major milestones and deliverables. This roadmap serves as a guide for the team and helps align stakeholders on the project's direction.
  - This is a crucial component of the planning stage of Agile, because your team will build these individual features during each sprint.
  - At this point, you will also develop a product backlog, which is a prioritized list of features and requirements for the project. When you plan sprints later on, your team will pull tasks from the product backlog.
- **Release Planning**: Plan for the deployment of the product increments to users. This includes defining release goals, timelines, and any necessary training or support materials.
  - In traditional waterfall project management, there is one implementation date that comes after an entire project has been developed.
  - In contrast, agile uses shorter development cycles (called sprints) with features released at the end of each cycle.
  - Before kicking off the project, you'll make a high-level plan for how and when your team will release these features.

Some Agile frameworks, like Scrum, implement the following additional steps:

- **Sprint Planning**: At the beginning of each sprint, the team selects user stories from the product backlog to work on during the sprint. The team estimates the effort required for each story and commits to completing a set of stories within the sprint duration.

  - Before each sprint begins, the stakeholders need to hold a sprint planning meeting to determine what will be accomplished by each person during that sprint, how it will be achieved, and assess the task load.
  - Sprint planning is a key event in Scrum, where your team will decide what work they can complete during the upcoming sprint.
  - It's important to share the load evenly among team members so they can accomplish their assigned tasks during the sprint.
  - The team will pull tasks from the product backlog and commit to completing them within the sprint duration.
  - You'll need to visually document your workflow for team transparency, shared understanding with the team, and identifying and removing bottlenecks.

- **Daily Stand-ups**: Hold brief daily meetings (usually 15 minutes) to discuss progress, plans for the day, and any blockers team members are facing. This helps keep everyone aligned and allows for quick issue resolution.

  - During these meetings, each team member will briefly talk about what they accomplished yesterday, what they plan to work on today, and any obstacles they're facing.
  - These daily meetings should be only 15 minutes long to keep them focused and efficient. They are not meant to be extended problem-solving sessions or a change to talk about general news items. Some teams will even hold these meetings standing up to encourage brevity.

- **Sprint Review and Retrospective**: At the end of each sprint, the team holds a sprint review to demonstrate the completed work to stakeholders and gather feedback. This is followed by a sprint retrospective, where the team reflects on the sprint process and identifies areas for improvement.
  - The sprint review is an opportunity for the team to showcase their work and receive feedback from stakeholders, ensuring that the product is aligned with user needs.
  - An in-person or video conference meeting allows both groups to build a relationship and discuss product issues that arise.
  - The sprint retrospective is a chance for the team to discuss what went well, what didn't, and how they can improve in the next sprint. This continuous improvement mindset is a key aspect of Agile methodologies.
  - If your team is new to Agile project management, do not skip this essential meeting.
  - It helps you gauge how much your team can tackle during each sprint and the most efficient sprint length for future iterations.
