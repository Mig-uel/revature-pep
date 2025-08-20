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

## Scrum Ceremonies

If you are new to the Agile approach, or the Scrum methodology in particular, you might not know about Scrum ceremonies. Here is an overview of the four essential Scrum ceremonies that help teams stay organized and focused.

**What are the four Scrum Ceremonies?**

Scrum ceremonies aka Scrum events are structured meetings that help teams plan, execute, and review their work in an Agile environment. These ceremonies provide a framework for collaboration, communication, and continuous improvement. The four main Scrum ceremonies are:

1. **Sprint Planning**: A meeting where the team defines the goals and scope of the upcoming sprint.
2. **Daily Stand-up**: A short daily meeting for the team to synchronize activities and create a plan for the next 24 hours.
3. **Sprint Review**: A meeting at the end of the sprint to showcase the work completed and gather feedback from stakeholders.
4. **Sprint Retrospective**: A meeting for the team to reflect on the sprint and identify areas for improvement.

Sprint planning occurs before the sprint, daily stand-up meetings happen every day during the sprint, sprint reviews take place at the end of the sprint, and sprint retrospectives occur after the sprint review.

These four Scrum ceremonies form the backbone of the Scrum methodology, providing structure and discipline to the Agile process. They help teams stay focused, aligned, and continuously improving their practices.

**Sprint Planning**

If your team starts sprinting without proper planning, you might find yourselves running in circles. Sprint planning is a crucial ceremony that sets the stage for a successful sprint by defining the goals and scope of the work to be done.

The first Scrum ceremony - sprint planning - creates a roadmap for the team, outlining the tasks and deliverables for the upcoming sprint. This ensures that everyone is aligned on the objectives and has a clear understanding of their responsibilities.

The sprint planning session does not have to be time consuming; an hour or two should be sufficient to establish a clear plan and get everyone on the same page for a one or two week sprint. The Scrum team, the product owner, and the Scrum Master should be present during this meeting.

During the sprint planning session, the team consults the product backlog to determine which user stories or tasks will be included in the sprint. The team estimates the effort required for each task and commits to completing a set of tasks within the sprint duration. This helps ensure that the team is focused on delivering value and meeting the sprint goals.

During the sprint planning meeting, the Scrum team will estimate how many items from the backlog they can complete with their existing resources. The Scrum Master facilitates the meeting, the product owner clarifies the details and requirements of the backlog items, and the team members define the work and effort necessary to complete each backlog item chosen for the sprint. A centralized work management platform can be beneficial in this process, helping the team track progress and manage tasks effectively.

**Daily Stand-up**

Stand-up meetings aka the daily Scrum are short, focused meetings held every day during the sprint. These meetings help the team synchronize their activities, share updates, and identify any blockers or challenges they are facing.

Traditionally, Scrum Masters keep the daily scrum to no longer than 15 minutes. These stand-up meetings are informal gathering designed to help identify any roadblocks and allow team members to discuss their progress, goals, and obstacles.

Ideally, the daily Scrum should take place at the beginning of the day with the Scrum Master, product owner, and development team present.

One way to prevent daily Scrums from exceeding 15 minutes is to ensure everyone is on the same page before the meetings begin. Many Scrum teams use a modern work management platform to help track each component's progress and status. If the Scrum Master or product owner notices that someone is falling behind, they can address the issue before the daily meeting.

The daily Scrum keeps each team member accountable. While leaders should never belittle or embarrass team members at these meetings, the requirement to report progress each day can motivate developers to stay efficient and productive.

**Sprint Review**

After the team has completed the sprint, they hold a sprint review to showcase the work completed and gather feedback from stakeholders. This meeting provides an opportunity for the team to demonstrate the product increment and ensure that it meets the defined acceptance criteria.

The Scrum team, Scrum Master, and product owner meet with other teams, managers, and executives to showcase what they have accomplished during the sprint. Ideally, the sprint review allows each team member to participate. The review's tone should be enthusiastic, with the team celebrating their accomplishments and sharing their insights.

Of course, Scrum teams should also solicit feedback from stakeholders during the sprint review. This feedback is invaluable for understanding how well the team has met the needs of the business and identifying areas for improvement in future sprints. In many cases, teams may need to change or update the products they build during the sprint. Revision requests are not a bad thing; a continually iterative, evolving process is the essence of Agile development.

The sprint review should last as long as necessary to fully demonstrate the team's new technology and have a productive conversation with stakeholders. After the sprint review, Scrum teams move on to the sprint retrospective.

**Sprint Retrospective**

The final Scrum ceremony is the sprint retrospective. During this last phase, the development team, the Scrum Master, and the product owner reflect on the sprint to identify what went well, what could be improved, and how to implement changes in the next sprint. This meeting fosters a culture of continuous improvement and helps the team adapt their processes for better outcomes in the future.

The retrospective usually lasts about an hour or two, depending on the length of the sprint. The Scrum Master facilitates the meeting, ensuring that everyone has a chance to share their thoughts and ideas.

Using feedback from stakeholders and the Scrum Master, the team should identify how it can improve its processes to have more effective sprints in the future. Agility and adaptability are core values of the Scrum process, so teams should strive to identify and implement changes that enhance their performance.

### Real World Application

**How to Keep Your Scrum Ceremonies Effective**

One way to ensure your Scrum sprints and ceremonies are as efficient as possible is to designate a Scrum Master to keep the team on track. The Scrum Master is responsible for facilitating the Scrum ceremonies, ensuring that the team is productive and focused on achieving the sprint goals. Scrum Masters coordinate daily Scrums and ensure everyone is on the same page. Some Scrum Masters rely on work management software to help track questions, accountability, and progress.

Despite being called a "master", Scrum Masters do not have direct authority over the other team members. Instead, they serve as facilitators and coaches, helping the team to self-organize and make decisions collaboratively. The Scrum Master is a servant-leader who works alongside product developers.

**Keep Your Team Improving with Scrum Ceremonies**

Scrum ceremonies are a vital part of the Scrum process. Do not neglect them just because your team is short on time. Instead, find ways to make these ceremonies more efficient and focused. This might involve setting clear agendas, using time-boxing techniques, or leveraging technology to streamline communication and collaboration. According to the Scrum Allegiance, 86% if respondents have initial planning sessions, 87% hold daily Scrum meetings, and 81% take the time for a Scrum retrospective. Scrum ceremonies empower teams to plan, maintain, and learn from sprints, ensuring a continuous cycle of improvement, adaptation, and steady productivity.

## Story Pointing and Burndown Charts

Story pointing and burndown charts are essential tools in Agile project management, particularly in Scrum. They help teams estimate the effort required for tasks and track progress throughout the sprint.

**Agile Stories: A Refresher**

Before we talk about story points in Agile, let us remind ourselves what stories are in the Agile context.

A story is a short, simple description of a feature told from the perspective of the person who desires the new capability, usually a user or customer. Stories are often written on index cards or in a digital format and include just enough information for the team to understand the feature and its value. The format typically follows the structure: "As a [user], I want [goal] so that [reason]."

Here's an example of a story: "I manage a small accounting team at work, and I need a way for us to easily share spreadsheets in real-time while being able to communicate with each other simultaneously."

**What are Story Points?**

Story Points (SP) are a unit of measure used to estimate the effort required to complete a user story or task in Agile development. They provide a relative measure of complexity, effort, and risk associated with a particular story, allowing teams to prioritize and plan their work effectively.

They are used by agile teams to provide estimates of the total amount of work required to completely implement items from the product backlog, or user stories. As a result, estimating story points actually entails estimating work and giving each backlog item a point value.

Put another way, it is a numeric value that helps the dev team understand the effort required to complete a story. The team assigns story points based on factors such as complexity, risk, and the amount of work involved.

Story points in Agile are abstract measurements that devs use instead of hours. Points are relative values, so a story with a value of four is twice as complex as a story with a value of two. The actual numbers do not matter - you could assign values between 1,000,000 and 5,000,000 if you want. Instead, you want to give the team an idea of the story's relative difficulty. Story points are not meant to be precise measurements, but rather a tool for facilitating discussion and understanding among team members.

**Story Points Vary Depending On:**

- **The team and individual member**

  - To the relative character of story points, there is an additional dimension: the effectiveness of the team responsible for estimations. One person differs from another based on a variety of criteria, including experience, expertise, and familiarity with the project. Accordingly, a backlog item may be worth five points for one side and only three for another. The same holds true for individual team members; junior and senior will likewise view the "size" of the effort differently.

- **Another value**

  - Because a story point may only exist in relation to another value, it is a relative unit. For example, if a tasks requires two narrative points to finish, it represents twice as much work as a task that required one story point. Comparably, a task estimated at one story point will require one-third effort compared to as task assessed at three story points. To express effort, you might utilize Fibonacci sequence values rather than linear 1 and 2. Rather than the exact numbers you allocate to Agile story points, what counts most is the ratio between the story points and the relative values.

**What is a Burndown Chart?**

A Burndown Chart is a visual representation of work completed versus work remaining over time in an Agile project. It helps teams track their progress and predict when they will complete their work. The chart typically displays the total amount of work (often measured in story points) on the vertical axis and time (usually in sprints) on the horizontal axis.

In order to depict the past and future of the project, the amount of work still to be done is displayed on a vertical axis, and the amount of time since the project's start is displayed on a horizontal axis. As the team completes work, the chart shows a downward trend, indicating that the amount of work remaining is decreasing.

As work is completed, the chart "burns down" towards zero, providing a clear picture of the team's progress. Burndown Charts are useful for identifying potential roadblocks, assessing team performance, and facilitating discussions about project timelines and deliverables.

**Types of Burndown Charts:**

There are two variants of burndown charts:

1. **Sprint Burndown Chart**: Tracks the progress of work completed during a single sprint. It helps the team monitor their velocity and adjust their plans as needed to meet sprint goals.
2. **Product Burndown Chart**: Tracks the overall progress of work completed for the entire project. It provides a high-level view of the project's status and helps stakeholders understand how much work remains to be done.

**What is Fibonacci Agile Estimation?**

Agile estimation refers to a way of quantifying the effort needed to complete a development task. Many agile teams use story points as the unit to score their tasks. The higher the number of points, the more effort the team believes the task will take.

The Fibonacci sequence is a popular method for assigning story points. In this approach, story points are assigned using the Fibonacci numbers (1, 2, 3, 5, 8, 13, etc.) to represent the relative size and complexity of tasks. The use of Fibonacci numbers helps teams account for uncertainty and variability in their estimates, as the gaps between the numbers increase, reflecting the increasing uncertainty associated with larger tasks.

**Why Use the Fibonacci Sequence for Agile Estimation?**

The Fibonacci sequence is used in Agile estimation because it helps teams make more accurate and realistic estimates. The increasing gaps between the numbers in the sequence reflect the uncertainty and complexity associated with larger tasks. This encourages teams to think critically about the effort required for each task and avoid underestimating or overestimating their work.

Agile consultant Mike Cohn popularized the use of the Fibonacci sequence for Agile estimation in his book "Agile Estimating and Planning." He argued that using Fibonacci numbers helps teams focus on relative sizing rather than absolute values, which can lead to more accurate estimates.

In his article on Fibonacci agile estimation, Cohn asks us to imagine holding a one-kilogram weight (2.2 pounds) in one hand and a two-kilogram weight (4.4 pounds) in the other. While the difference in weight is clear, it's not as easy to quantify the difference in effort required to lift each weight. The difference in weights will need to be greater so that our brains can easily perceive the difference in effort.

This is why Cohn recommends using the Fibonacci sequence for Agile estimation. The numbers your team can choose from takes larger jumps as the sequence progresses, but they grow at a constant rate with each number representing about a 60% increase over the previous number. Cohn points out that even as the numbers get huge, our brains can still perceive the differences if the next number is 60% greater than the last.

**How Does Fibonacci Agile Estimation Work in Practice?**

Imagine your team wanted to estimate the effort needed to build a new widget in your app. Everyone agrees that this task would rate a high level of difficulty and take a long time to complete it.

But now imagine your team used a linear, even number scoring scale for story point estimation: 2, 4, 6, 8, 10...up to 50. Even if everyone agreed this new widget would be on the high end of the point scale, could you all agree whether to assign it 42 points? How about 46 points? Or 548 points?

As the numbers get higher on this scoring scale, you will find it more difficult to determine the right number because there too many options, and the numbers at the high end are not distinct enough from each other.

Moreover, remember that the goal with story points is only to estimate the level of effort. There is no reason to try to zero in on the perfect story-point score. These numbers are just a guide to help your team gauge how much time a task will take and how many resources you will need to devote to it. This is why no viable agile estimation uses decimals.

If your team was using the Fibonacci sequence to estimate the effort to develop this new widget, you would have only a few numbers to choose from at the top end of the scale: 34, 55, 89, and 144. The gaps between these numbers are large enough that your team can easily agree on the level of effort required to complete the task.

If you do the math, you will see Cohn is correct that each of these numbers jump about 60% from the previous number. And as you can see, it would be much easier to reach a consensus on whether the task is a 55 or an 89 than it would be to agree on whether it's a 42 or a 46.

### Real World Application

**Why Should Teams Use Story Points in Agile?**

Story points in Agile benefit development teams and product owners alike.

The effort is the result of several things coming together, and your team needs to take those into account when estimating story points. This includes factors like the complexity of the task, the skills of the team members, and any potential obstacles that could arise during development.

- Amount of work: The total amount of work required to complete the task, including design, coding, testing, and documentation.
- Work's complexity: The complexity of the task, including any technical challenges or dependencies that may arise during development.
- Uncertainties and risks: Any uncertainties or risks associated with the task, such as potential changes in requirements or dependencies on other tasks.

Stories points are also relative, so over time, repetition may have a role in determining how much weight you can give certain actions. As a result, the "size" of the finished project will also depend on how experienced your team is with the project and how familiar they are with the technologies involved.

Benefits for development teams:

- The team gets a better understanding of what is required of them, making it easier to plan and execute the work.
- The team won't over plan or under plan their work, which can lead to missed deadlines or wasted effort.
- The team can focus on delivering value to the customer rather than getting bogged down in detailed planning.
- The team knows how much to plan in a sprint, thereby letting them work at a sustainable pace.
- The team can create a reasonable estimate of how much work they can accomplish in a sprint, which helps them avoid burnout and maintain a healthy work-life balance.

Benefits for product owners:

- They can better assess an item's return on investment (ROI) by understanding the effort involved in delivering it.
- They can prioritize work more effectively by comparing the relative effort of different items.
- They can communicate more clearly with stakeholders about the progress and challenges of the project.
- Owners can better understand the technical risk associated with a task, which helps them make informed decisions about prioritization and resource allocation.
- They can better forecast the timeline and budget for the project, allowing for more accurate planning and resource allocation.

However, team members should be careful to avoid some common pitfalls when using story points in Agile:

- Do not give story points to small tasks that can be easily completed in a few hours. Instead, focus on larger tasks that require more effort and complexity.
- Story point creation is a team effort, not a one-person show. Everyone should contribute to the discussion and estimation process.
- Do not average story points across the team. Each team member may have different perspectives and experiences, so it is essential to consider everyone's input.
- Do not let one variable influence the story point estimation process. Instead, consider all relevant factors, such as complexity, effort, and risk.

TODO

## Waterfall Methodology

The Waterfall methodology is a linear and sequential approach to software development. It is one of the earliest methodologies used in software engineering and is characterized by distinct phases that must be completed before moving on to the next one.

The phases typically include:

1. **Requirements Gathering**: In this initial phase, all possible requirements of the system to be developed are gathered and documented. This phase is crucial as it sets the foundation for the entire project.

2. **System Design**: Based on the gathered requirements, the system's architecture and design are created. This includes both high-level design (HLD) and low-level design (LLD) documents.

3. **Implementation**: In this phase, the actual coding takes place. Developers write code according to the design specifications created in the previous phase.

4. **Testing**: After implementation, the software is thoroughly tested to identify and fix any defects or issues. This phase ensures that the software meets the specified requirements.

5. **Deployment**: Once testing is complete, the software is deployed to the production environment where it will be used by end-users.

6. **Maintenance**: After deployment, the software enters the maintenance phase, where it is updated and improved based on user feedback and changing requirements.

As each phase completes, the project "spills" over into the next step like a waterfall, with each phase flowing into the next in a linear fashion. This is a tried-and-true method for software development that has been used for decades.

**Advantages**

- It is a simple model that can be followed by developers in developing software.
- It is easy to understand and manage due to its sequential nature.
- All the phases are clearly defined, making it easy to track progress and manage resources.
- It works well for smaller projects with well-defined requirements.
- It provides a structured approach that can be helpful for teams new to software development.

**Disadvantages**

- It is not ideal for projects with changing requirements, as it is difficult to go back and make changes once a phase is completed.
- It consumes a lot of time and resources, as each phase must be completed before moving on to the next one.
- It does not allow for much flexibility or iteration, which can be a drawback in fast-paced development environments.
- Since each phase needs to be completed before moving on to the next, it can lead to delays if any phase takes longer than expected. As well as, testing is done only after the implementation phase, which can lead to discovering issues late in the development process.

### Real World Application

In the olden days, Waterfall model was used to develop enterprise applications like Customer Relationship Management (CRM) systems, Human Resource Management (HRM) systems, Supply Chain Management (SCM) systems, Inventory Management Systems, Point of Sales (POS) systems, and many more. However, with the advent of Agile methodologies, the use of Waterfall has declined in favor of more flexible and iterative approaches.

With the evolution of technology, there were cases where large scale enterprise systems,with the waterfall model as the default choice, were developed over a period of two to three years byt became redundant by the time they were completed. Slowly, these enterprise systems switch over to more flexible and less expensive models, but the waterfall model continued to be preferred in systems where:

- A human life is a stake and the cost of failure is high, such as in healthcare or aerospace applications.
- Money and time are secondary factors and what matters most is the quality and reliability of the software.
- Military and aircraft programs where requirements are well-defined and unlikely to change.
- Projects with an extremely high degree of oversight and regulatory compliance, such as in finance or pharmaceuticals.

### Implementation

The original Waterfall method's steps included:

- Requirements determination
- Design
- Implementation
- Verification
- Maintenance

Other models change the Requirements phase into the Idea phase, or break the Requirements phase out into Planning and Analysis. Furthermore, some models further break the Design phase out into Logical and Physical design sub-phases. However, the basic underlying principles remain the same.

Below, the major stages of the Waterfall method are described in detail:

- The Waterfall method makes the assumption that all requirements can be gathered up front during the Requirements phase.
  - Communication with the user is front-loaded into this phase, as the Project Manager does their best to elicit all necessary information. Once this stage is complete, the process runs "downhill" like a waterfall, where the water starts from the top and flows down to the bottom.
- The Design phase involves creating a detailed blueprint for the software solution, including architecture, user interfaces, and data models. This phase is best described by breaking it up into Logical Design and Physical Design sub-phases.
  - During the Logical Design phase, the system's analysts makes use of the information collected in the Requirements phase to design the system independently of any hardware or software system.
  - Once the higher-level Logical Design is complete, the Physical Design phase begins, where the system's design is translated into a detailed specification that can be implemented in code.
- The Implementation phase involves the actual coding of the software solution based on the specifications created during the Design phase.
- The Verification phase involves testing the software to ensure it meets the specified requirements and is free of defects. It was originally called for to ensure that the project is meeting customer expectations.
  - The project is rolled out to the customer, and the Maintenance phase begins.
- During the Maintenance phase, the customer is using the software, and any issues or bugs that arise are addressed. This phase also includes updates and enhancements to the software as needed.

## Agile vs Waterfall

Agile and Waterfall are two distinctive methodologies of software development. While both aim to deliver high-quality software, they differ significantly in their approach and execution.

- Waterfall is a linear and sequential approach, where each phase must be completed before the next one begins. This makes it easier to manage and control, but can lead to inflexibility and difficulty in accommodating changes.
- Agile, on the other hand, is an iterative and incremental approach that emphasizes flexibility and collaboration. It allows for changes to be made at any stage of the development process, making it easier to adapt to evolving requirements and customer feedback.

Following the Agile methodology, development will move through a series of cycles throughout the lifetime of the project. The development phase, review, feedback, and then approval of the work item - either yes or no. If yes, implement and complete the task. If no, record and make any necessary changes, track and adjust the backlog or prioritization to reflect the newly acquired knowledge, and then move onto the next work item.

Following the Waterfall methodology, development will move through a simple linear process: requirements gathering, design, implementation, testing, deployment, and maintenance. Each phase must be completed before moving on to the next one, and changes can be difficult to accommodate once a phase is completed.

In summary, the choice between Agile and Waterfall depends on the specific needs and constraints of the project, as well as the preferences of the development team and stakeholders.

### Real World Application

**The advantages of Waterfall:**

- Required less coordination and communication between team members due to clearly defined sequential phases.
- A clear project phase structure that is easy to understand and manage.
- The cost of the project can be estimated after the requirements phase, allowing for better budgeting and resource allocation.
- Better focus on documentation and requirements upfront, which can lead to a more stable foundation for the project.
- The design phase is more methodical, allowing for a more thorough understanding of the system before implementation begins.

**The disadvantages of Waterfall:**

- Inflexibility in accommodating changes once a phase is completed.
- Limited customer involvement and feedback during the development process.
- Potential for scope creep if requirements are not well-defined upfront.
- Difficulty in managing and mitigating risks throughout the project lifecycle.
- Harder to break up and share work among team members due to the linear nature of the process.
- Risk of time waste due to delays in one phase affecting the entire project timeline.
- Additional hiring requirements to fulfill specialized phase teams whereas Agile encourages more cross-functional teams.
- Extra communication overhead during handoffs between phases, which can lead to misunderstandings and delays.
- Product ownership and engagement can be more challenging, as stakeholders may be less involved throughout the process.

**The advantages of Agile:**

- Faster feedback loops and more frequent releases, allowing for quicker adjustments based on user feedback.
- Identifies problems and bottlenecks earlier in the development process, leading to more efficient problem-solving.
- Higher potential for customer satisfaction due to continuous involvement and feedback.
- Time to market is dramatically reduced, allowing for quicker delivery of value to customers.
- Better visibility/accountability for the team, as progress is tracked and communicated regularly.
- Dedicated teams drive better productivity and ownership of the work.
- Flexible prioritization of tasks based on changing requirements and customer needs.

**The disadvantages of Agile:**

- Critical path and inter-project dependencies may not be clearly defined compared to Waterfall.
- There is an organizational learning curve for teams new to Agile methodologies.
- Difficulty in estimating project timelines and budgets due to the iterative nature of Agile.
- Less emphasis on documentation can lead to knowledge gaps and challenges in onboarding new team members.
- True agile execution with a continuous deployment pipeline has many technical challenges, such as managing dependencies and ensuring code quality.
