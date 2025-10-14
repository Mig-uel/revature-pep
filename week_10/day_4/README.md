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
