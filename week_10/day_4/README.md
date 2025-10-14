# Spring, HTML/CSS, JavaScript Intro - Day 4

## Overview of CSS

CSS stands for Cascading Style Sheets. It is used to style and layout web pages — for example, to alter the font, color, size and spacing of your content, split it into multiple columns, or add animations and other decorative features.

A CSS file consists of a set of rules that define how the content of specified elements should be displayed. A CSS rule consists of a selector and a declaration block:

```css
selector {
  property: value;
  property: value;
}
```

Declarations are key/value pairs that specify the styling to be applied to the selected elements. For example:

```css
h1 {
  color: blue;
  font-size: 12px;
}
```

## Inline vs Internal vs External CSS

A CSS rule has two main parts:

- The selector, which points to the HTML element you want to style.
- The declaration block, which contains one or more declarations separated by semicolons. Each declaration includes a CSS property name and a value, separated by a colon.

#### CSS Stylesheets

There are three ways to apply CSS to HTML:

1. **Inline Styles**

Inline styles are applied directly to an HTML element using the `style` attribute. For example:

```html
<h1 style="color:blue;">This is a blue heading</h1>
<p style="color:red;">This is a red paragraph.</p>
```

This method is useful for quick testing or applying unique styles to a specific element, but it is not recommended for larger projects as it can lead to messy and hard-to-maintain code.

2. **Internal (Embedded) CSS**

Internal CSS is defined within a `<style>` element in the `<head>` section of the HTML document. For example:

```html
<head>
  <style>
    h1 {
      color: blue;
    }
    p {
      color: red;
    }
  </style>
</head>
<body>
  <h1>This is a blue heading</h1>
  <p>This is a red paragraph.</p>
</body>
```

Internal styles are useful for small to medium-sized projects or specific pages that require unique styling. They have a higher specificity than external stylesheets but lower than inline styles. Internal styles can be overridden by inline styles or styles defined later in the cascade.

3. **External CSS**

External CSS is defined in a separate `.css` file and linked to the HTML document using the `<link>` element in the `<head>` section. For example:

```html
<head>
  <link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
  <h1>This is a blue heading</h1>
  <p>This is a red paragraph.</p>
</body>
```

External stylesheets are recommended for larger projects as they provide better organization and maintainability. They allow you to apply the same styles across multiple pages, making it easier to update the design of an entire website by modifying a single CSS file. External stylesheets have the lowest specificity compared to inline and internal styles, meaning they can be overridden by both.

The three types of CSS can be used together in a single HTML document, but it's important to understand their specificity and how they interact with each other. In general, it's best to use external stylesheets for the majority of your styling needs and reserve inline and internal styles for specific cases where necessary.

## CSS Box Model

The CSS box model is a fundamental concept in web design that describes how elements on a web page are structured and how they interact with each other. According to the box model, every HTML element can be considered as a rectangular box that consists of four main components:

1. **Content**: The actual content of the element, such as text or images.
2. **Padding**: The space between the content and the border. Padding is transparent and can be adjusted using CSS properties like `padding-top`, `padding-right`, `padding-bottom`, and `padding-left`.
3. **Border**: The border surrounds the padding (if any) and content. The border can be styled using CSS properties like `border-width`, `border-style`, and `border-color`.
4. **Margin**: The outermost layer that creates space between the element and other elements on the page. Margins are also transparent and can be adjusted using CSS properties like `margin-top`, `margin-right`, `margin-bottom`, and `margin-left`.

The total width and height of an element can be calculated by adding the content width/height, padding, border, and margin. Understanding the box model is essential for effective web design and layout, as it helps you control the spacing and alignment of elements on a web page.

## Sibling Selectors

Sibling selectors in CSS are used to select elements that are siblings (i.e., share the same parent) of a specified element. There are two types of sibling selectors:

- **Adjacent Sibling Selector (`+`)**: This selector targets the immediate next sibling of a specified element. For example, `A + B` selects the first `B` element that is immediately preceded by an `A` element.

```css
h1 + p {
  color: blue;
}
```

This rule will style the first `<p>` element that comes immediately after an `<h1>` element.

- **General Sibling Selector (`~`)**: This selector targets all siblings of a specified element that come after it, regardless of their position. For example, `A ~ B` selects all `B` elements that are preceded by an `A` element.

```css
h1 ~ p {
  color: green;
}
```

This rule will style all `<p>` elements that come after an `<h1>` element, not just the first one.

## Advanced CSS Selectors

Advanced CSS selectors allow you to target elements more precisely based on their attributes, states, or relationships with other elements. Here are some examples of advanced CSS selectors:

- **Attribute Selectors**: These selectors target elements based on their attributes and attribute values.

```css
a[href^="https"] {
  color: green; /* Selects all <a> elements with href attribute starting with "https" */
}
input[type="text"] {
  border: 1px solid #ccc; /* Selects all <input> elements with type attribute equal to "text" */
}
img[alt$="icon"] {
  width: 50px; /* Selects all <img> elements with alt attribute ending with "icon" */
}
```

- **Child Selectors**: These selectors target elements based on their position within the parent element.

```css
ul > li {
  list-style-type: square; /* Selects all <li> elements that are direct children of <ul> */
}
div > p {
  margin-bottom: 10px; /* Selects all <p> elements that are direct children of <div> */
}
```

- **Descendant Selectors**: These selectors target elements that are descendants of a specified element, regardless of their depth in the hierarchy.

```css
div p {
  font-size: 14px; /* Selects all <p> elements that are descendants of <div> */
}
section article h2 {
  color: darkblue; /* Selects all <h2> elements that are descendants of <article> within <section> */
}
```

- **Pseudo-classes**: These selectors target elements based on their state or position.

```css
a:hover {
  text-decoration: underline; /* Selects <a> elements when hovered over */
}
li:first-child {
  font-weight: bold; /* Selects the first <li> element within its parent */
}
input:focus {
  border-color: blue; /* Selects <input> elements when they are focused */
}
```

- **Pseudo-elements**: These selectors allow you to style specific parts of an element.

```css
p::first-letter {
  font-size: 200%; /* Selects the first letter of each <p> element */
}
h1::after {
  content: " ★"; /* Adds a star after each <h1> element */
  color: gold;
}
```

These advanced selectors provide powerful ways to target and style elements in your web pages, allowing for more complex and dynamic designs.

## Cascading Nature of CSS

The CSS Cascade is the algorithm that determines which CSS rules apply to an element when there are multiple conflicting rules. The cascade takes into account three main factors: specificity, importance, and source order.

1. **Specificity**: Specificity is a measure of how specific a selector is. The more specific a selector, the higher its specificity value. Specificity is calculated based on the types of selectors used:

   - Inline styles (e.g., `style="..."`) have the highest specificity.
   - ID selectors (e.g., `#id`) have a high specificity.
   - Class selectors (e.g., `.class`), attribute selectors (e.g., `[type="text"]`), and pseudo-classes (e.g., `:hover`) have a medium specificity.
   - Element selectors (e.g., `div`, `p`) and pseudo-elements (e.g., `::before`, `::after`) have the lowest specificity.

   When multiple rules apply to the same element, the rule with the highest specificity takes precedence.

2. **Importance**: The `!important` declaration can be added to a CSS property to give it the highest priority, overriding any other conflicting rules, regardless of specificity. However, it is generally recommended to use `!important` sparingly, as it can make debugging and maintaining CSS more difficult.
3. **Source Order**: When two rules have the same specificity and importance, the rule that appears later in the CSS (or in the HTML if using inline styles) takes precedence. This means that if you have two conflicting rules with the same specificity, the one that is defined last will be applied.

## Specificity

CSS specificity is a ranking system that determines which CSS rule is applied to an element when multiple rules could apply. Specificity is calculated based on the types of selectors used in the CSS rules. The more specific a selector is, the higher its specificity value, and the more likely it is to be applied. Specificity is calculated using a four-part value (a, b, c, d):

- **a**: Inline styles (e.g., `style="..."`) - counts as 1 if present, otherwise 0.
- **b**: Number of ID selectors (e.g., `#id`) - counts the number of ID selectors in the rule.
- **c**: Number of class selectors (e.g., `.class`), attribute selectors (e.g., `[type="text"]`), and pseudo-classes (e.g., `:hover`) - counts the total number of these selectors in the rule.
- **d**: Number of element selectors (e.g., `div`, `p`) and pseudo-elements (e.g., `::before`, `::after`) - counts the total number of these selectors in the rule.

When comparing specificity values, the values are compared from left to right (a, b, c, d). The first value that is different determines which rule has higher specificity. For example:

- `#header .nav li a` has a specificity of (0, 1, 1, 2) (1 ID, 1 class, 2 elements)
- `.nav li a` has a specificity of (0, 0, 1, 2) (0 IDs, 1 class, 2 elements)

In this case, the first rule has a higher specificity because it has an ID selector, so it will be applied over the second rule.

Regardless of specificity, inline styles will always take precedence over any other CSS rules. Additionally, the `!important` declaration can be used to override specificity, but it should be used sparingly as it can make debugging and maintaining CSS more difficult.

## Responsive Web Design

### Implementation

To implement responsive web design, you can use the following techniques:

- **Fluid Grids**: Use relative units like percentages or `em` instead of fixed units like pixels for widths and heights. This allows elements to resize based on the viewport size (viewport = visible area of a web page).

```css
.container {
  width: 80%; /* Container will take up 80% of the viewport width */
}
```

- **Flexible Images and Media**: Set images and media to scale within their containing elements using CSS properties like `max-width: 100%` and `height: auto`.

```css
img {
  max-width: 100%; /* Image will scale down to fit within its container */
  height: auto; /* Maintain aspect ratio */
}
```

- **Media Queries**: Use CSS media queries to apply different styles based on the device's characteristics, such as screen width, height, resolution, and orientation.

```css
/* Example of a media query for small screens */
@media (max-width: 600px) {
  body {
    background-color: lightblue; /* Change background color for small screens */
  }
  .container {
    width: 100%; /* Make container full width on small screens */
  }
}

/* Example of a media query for medium screens */
@media (min-width: 601px) and (max-width: 1200px) {
  body {
    background-color: lightgreen; /* Change background color for medium screens */
  }
  .container {
    width: 80%; /* Make container 80% width on medium screens */
  }
}
```

- `@media only screen and (max-width: 600px) { ... }`: This media query applies styles only when the screen width is 600 pixels or less, typically for mobile devices.
- `@media only screen and (min-width: 601px) and (max-width: 1200px) { ... }`: This media query applies styles when the screen width is between 601 and 1200 pixels, typically for tablets and small desktops.

- **Viewport Meta Tag**: Include the viewport meta tag in the `<head>` section of your HTML document to control the layout on mobile browsers.

```html
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
```

- This tag sets the viewport width to the device's width and the initial zoom level to 1.0, ensuring that your responsive design works correctly on mobile devices.

## Flexbox

CSS Flexbox (Flexible Box Layout) is a layout model that allows you to design complex layouts more easily and efficiently. It provides a way to distribute space along a single axis (either horizontally or vertically) and align items within a container.

Key attributes of Flexbox:

- `display: flex;`: This property is applied to a container element to enable Flexbox layout for its child elements (flex items).
- `flex-direction`: This property defines the direction of the main axis (row or column) along which the flex items are laid out. Possible values are `row`, `row-reverse`, `column`, and `column-reverse`.
  - `row`: Items are laid out horizontally from left to right.
  - `column`: Items are laid out vertically from top to bottom.
- `flex-wrap`: This property controls whether flex items should wrap onto multiple lines if they exceed the container's width. Possible values are `nowrap`, `wrap`, and `wrap-reverse`.
  - `nowrap`: All items are kept on a single line (default).
  - `wrap`: Items will wrap onto multiple lines if necessary.
- `justify-content`: This property aligns flex items along the main axis. Possible values include `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, and `space-evenly`.
  - `flex-start`: Items are aligned to the start of the container.
  - `center`: Items are centered within the container.
- `align-items`: This property aligns flex items along the cross axis (perpendicular to the main axis). Possible values include `flex-start`, `flex-end`, `center`, `baseline`, and `stretch`.
  - `stretch`: Items are stretched to fill the container (default).
  - `center`: Items are centered along the cross axis.
- `flex`: This property is shorthand for `flex-grow`, `flex-shrink`, and `flex-basis`. It defines how a flex item will grow or shrink to fill the available space in the container.
  - `flex-grow`: Defines the ability of a flex item to grow if necessary. A value of `1` means the item can grow to fill available space, while `0` means it will not grow.
  - `flex-shrink`: Defines the ability of a flex item to shrink if necessary. A value of `1` means the item can shrink to fit within the container, while `0` means it will not shrink.
  - `flex-basis`: Defines the initial size of a flex item before any growing or shrinking occurs. It can be set to a specific value (e.g., `100px`) or to `auto`.

## Grid Layout

CSS Grid Layout is a two-dimensional layout system that allows you to create complex grid-based designs with ease. It provides a way to define rows and columns in a container and place items within those grid areas.

Key attributes of CSS Grid Layout:

- `display: grid;`: This property is applied to a container element to enable Grid layout for its child elements (grid items).
- `grid-template-columns` and `grid-template-rows`: These properties define the number and size of columns and rows in the grid. You can specify sizes using fixed units (e.g., `px`, `em`) or flexible units (e.g., `fr` for fractional units).
- `gap`: This property defines the space between grid items. You can set both row and column gaps using `row-gap` and `column-gap`, or use the shorthand `gap` to set both at once.
- `grid-column` and `grid-row`: These properties allow you to specify the starting and ending positions of a grid item within the grid. You can use line numbers or named grid areas to define the placement.
- `grid-area`: This property allows you to assign a grid item to a named grid area defined in the `grid-template-areas` property.
- `justify-items` and `align-items`: These properties control the alignment of grid items within their grid cells along the horizontal and vertical axes, respectively. Possible values include `start`, `end`, `center`, and `stretch`.
- `justify-content` and `align-content`: These properties control the alignment of the entire grid within the container along the horizontal and vertical axes, respectively. Possible values include `start`, `end`, `center`, `space-between`, `space-around`, and `stretch`.
