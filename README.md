# LearningPlaywright

A hands-on learning repository for JavaScript fundamentals, browser automation, and QA practices. The material is organized into numbered chapters, with short code examples, practice files, and reference notes.

## Learning roadmap

| Folder | Topics |
| --- | --- |
| [`00_chapter_Prompt_Engg/`](00_chapter_Prompt_Engg/) | Prompt engineering with the RICE-POT framework, problem statements, anti-hallucination guidance, QA templates, and LLM references |
| [`01_chapter_JS_Basics/`](01_chapter_JS_Basics/) | Basic JavaScript examples and an introduction to the DOM |
| [`02_chapter_JS_keyword_Identifiers/`](02_chapter_JS_keyword_Identifiers/) | JavaScript engines, `var`/`let`/`const`, identifiers, naming rules, and comments |
| [`03_chapter_JS_Literals/`](03_chapter_JS_Literals/) | Values and literals, including numbers, strings, `null`, `undefined`, and special values |
| [`04_chapter_JS_Operators/`](04_chapter_JS_Operators/) | Assignment, arithmetic, comparison, logical, string, `typeof`, and ternary operators |
| [`05_chapter_JS_Incre_Decre_Op/`](05_chapter_JS_Incre_Decre_Op/) | Increment/decrement operators, nullish coalescing, and practice exercises |

The chapters are intended to be explored in order. Example files are standalone learning exercises; not every file is a complete application.

## Running JavaScript examples

Install [Node.js](https://nodejs.org/) to run the command-line examples. From the repository root, run an individual file:

```sh
node 01_chapter_JS_Basics/HelloWorld.js
node 05_chapter_JS_Incre_Decre_Op/practice_Incre_Decre.js
```

The DOM chapter explains browser APIs. Examples that use browser objects such as `document` need to run in a browser page rather than directly in Node.js.

## Selenium example

The repository also includes a Maven-based Selenium and TestNG framework at [`00_chapter_Prompt_Engg/Selenium_Framwork/`](00_chapter_Prompt_Engg/Selenium_Framwork/). It contains a Salesforce login test, page objects, configuration, and a TestNG suite.

Requirements: Java 17 or later, Maven, and a supported browser (Chrome, Edge, or Firefox). To run the suite, change to the framework directory and execute:

```sh
mvn test
```

Review the test configuration before running; the suite launches a browser and accesses the Salesforce login page.

## Repository structure

```text
LearningPlaywright/
├── 00_chapter_Prompt_Engg/
│   ├── LLM_Basics/
│   └── Selenium_Framwork/
├── 01_chapter_JS_Basics/
├── 02_chapter_JS_keyword_Identifiers/
├── 03_chapter_JS_Literals/
├── 04_chapter_JS_Operators/
└── 05_chapter_JS_Incre_Decre_Op/
```
