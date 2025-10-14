# Spring, HTML/CSS, JavaScript Intro - Day 3

## Overview of HTML

HTML stands for HyperText Markup Language. It is the standard markup language for creating web pages and web applications. HTML describes the structure of a web page semantically and originally included cues for the appearance of the document.

- HyperText refers to the links that connect web pages to one another, either within a single website or between websites.
- Markup Language refers to the way tags are used to define the page layout and elements within the page.

#### Purpose of HTML

HTML provides the fundamental structure for web pages. It defines how content should display and organize using various elements represented by tags. HTML is the backbone of the web, forming the basis for web browsers to render content.

#### What HTML Does

- **Creates Structure**: HTML tags define a web page's structure including elements like headings, paragraphs, lists, links, images, and more.
- **Semantics**: HTML tags not only structure content but also provide meaning to the content, helping search engines and assistive technologies understand the content better.
- **Links**: HTML allows the creation of hyperlinks, enabling navigation between different web pages and resources.
- **Multimedia**: HTML supports embedding images, audio, and video content directly into web pages.

#### Key HTML Elements

- **Paragraphs**: `<p>` defines a paragraph.
- **Line Breaks**: `<br>` inserts a line break.
- **Headings**: `<h1>` to `<h6>` define headings, with `<h1>` being the highest level.
- **Links**: `<a>` defines a hyperlink.
- **Images**: `<img>` embeds an image.
- **Blocks**: `<div>` defines a division or section in an HTML document.

#### Applications of HTML

- **Web Development**: HTML is used to create and design web pages and web applications.
- **Navigation**: HTML enables the creation of navigation menus and links between different sections of a website.
- **Embedding Media**: HTML allows for the integration of multimedia elements like images, videos, and audio into web pages.
- **Client-Side Storage**: HTML5 introduced features for client-side storage, allowing web applications to store data locally on the user's device.
- **Game Development**: HTML5 provides capabilities for creating browser-based games using the `<canvas>` element and WebGL.
- **Data Entry Support**: HTML forms allow users to input data, which can be processed by web applications.
- **Interacting with Native APIs**: HTML5 includes features that enable web applications to interact with device hardware and native APIs, such as geolocation and camera access.

## HTML Document Structure

The HTML document structure refers to the hierarchical organization of elements within an HTML document. It defines the logical structure and semantic meaning of the content on a web page. The main components of an HTML document structure include:

1. **DOCTYPE Declaration**: The `<!DOCTYPE html>` declaration at the beginning of the document specifies the HTML version being used (HTML5 in this case).
2. `<html>` Element: The root element that encapsulates the entire HTML document.
3. `<head>` Element: Contains meta-information about the document, such as the title, character set, stylesheets, and scripts.
4. `<body>` Element: Contains the main content of the document, including text, images, links, and other elements.

Within the `<body>`, HTML provides a range of semantic elements to structure content meaningfully, such as `<header>` for the header, `<nav>` for navigation, `<main>` for the main content, `<section>` for sections of content, `<article>` for independent articles, `<aside>` for side content, and `<footer>` for the footer.

The HTML document is structured to provide logical and meaningful organization of content, enhancing accessibility, SEO, and user experience.

#### Document Object Model (DOM)

The Document Object Model (DOM) is a programming interface for web documents. It represents the structure of an HTML document as a tree of objects, allowing developers to manipulate and interact with the content and structure of a web page dynamically using JavaScript.

It is a cross-platform and language-independent convention that defines how programming languages can interact with and manipulate the structure, style, and content of web documents.

The HTML DOM represents the document as a hierarchical tree structure called the node tree. Each element, attribute, and piece of text in the HTML document is represented as a node in this tree. The DOM provides methods and properties to access, modify, and manipulate these nodes.

The DOM data structure comprises of nodes, which are related in a hierarchical manner. Each node has a parent node on which it depends, and it can have 0, 1, or multiple child nodes. The topmost node in the hierarchy is called the root node, which represents the entire document.

Nodes at the same level, which all depend on the same parent node, are called sibling nodes. In this node family, the entire DOM tree depends on a main node called the Document node, which represents the entire HTML document.

#### Types of Nodes

- **Document**: The root node from which all other nodes descend.
- **Element**: Represents HTML elements (e.g., `<div>`, `<p>`, `<a>`). It is the only node type that can have attributes and child nodes.
- **Attribute**: Represents attributes of HTML elements (e.g., `class`, `id`). Attributes are not part of the DOM tree but are associated with element nodes.
- **Text**: Represents the text content within HTML elements. Text nodes are always leaf nodes and cannot have child nodes.
- **Comment**: Represents comments in the HTML document. Comment nodes are also leaf nodes and cannot have child nodes.

The DOM also provides events that can be triggered by user interactions, such as clicks, key presses, and mouse movements. Developers can attach event listeners to specific nodes in the DOM, allowing them to respond to user actions and create dynamic web applications.

The DOM represents the internal browser representation of the HTML document. It forms a tree-like model where elements are objects with properties and methods. While developers cannot directly access or modify the DOM using HTML, they can use JavaScript to interact with and manipulate the DOM.

### Real World Application

The HTML document structure and the DOM are fundamental concepts in web development and they have numerous real-world applications:

- **Web Development**: Understanding the HTML document structure and the DOM is essential for web developers to create well-structured and semantically meaningful web pages. It allows them to organize content effectively, improve accessibility, and enhance user experience.
- **Single Page Applications (SPAs)**: SPAs rely heavily on the DOM to dynamically update and manipulate content without requiring full page reloads. Developers can use JavaScript to modify the DOM in response to user interactions, creating a seamless and interactive user experience.
- **Web Scrapers**: Web scrapers use the DOM to extract data from web pages. By navigating the DOM tree, scrapers can locate specific elements and retrieve their content for further processing or analysis.
- **Browser Extensions**: Browser extensions often interact with the DOM to modify the appearance or behavior of web pages. They can add new elements, change styles, or inject scripts to enhance functionality.
- **Accessibility Tools**: Accessibility tools, such as screen readers, rely on the semantic structure of the HTML document and the DOM to provide meaningful navigation and content interpretation for users with disabilities.

## Inline and Block Elements

#### Block Elements

Block elements form the main content structure of a webpage. They typically start on a new line and take up the full width available, creating a "block" of content. Examples of block elements include:

- Start on a new line before and after the element.
- Span the full horizontal width within their parent container.
- Have default margins (top and bottom) added by the browser.

**Syntax**: Block elements consist of opening and closing tags, with content placed between them.

#### Common Block-Level Elements

- `<p>`: Defines a paragraph.
- `<h1>` to `<h6>`: Define headings, with `<h1>` being the highest level.
- `<div>`: Defines a division or section in an HTML document.
- `<ul>`: Defines an unordered list.
- `<ol>`: Defines an ordered list.
- `<li>`: Defines a list item.
- `<header>`: Defines a header for a document or section.
- `<footer>`: Defines a footer for a document or section.
- `<section>`: Defines a section in a document.
- `<article>`: Defines an independent, self-contained article.
- `<hr>`: Defines a thematic break (horizontal rule) in the content.

#### Inline Elements

Inline elements represent a specific portion of text within a block-level element. They typically do not start on a new line and only take up as much width as necessary.

**Syntax**: Inline elements also consist of opening and closing tags, with content placed between them.

#### Common Inline Elements

- `<a>`: Defines a hyperlink.
- `<span>`: Defines a section in a document (used for styling purposes).
- `<strong>`: Defines important text (usually displayed in bold).
- `<em>`: Defines emphasized text (usually displayed in italics).
- `<img>`: Embeds an image (self-closing tag).
- `<br>`: Inserts a line break (self-closing tag).
- `<code>`: Defines a piece of computer code.

#### Key Differences Between Block and Inline Elements

| Feature  | Block Elements       | Inline Elements                                |
| -------- | -------------------- | ---------------------------------------------- |
| New Line | Start on a new line  | Do not start on a new line; flows horizontally |
| Width    | Take up full width   | Take up only as much width as necessary        |
| Margins  | Have default margins | Do not have default margins                    |
