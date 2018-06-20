# Project planning

## Overview 

There are many things to take into account when you're setting out to create a digital edition of texts. Start with your research questions and work you way back: how can you set up your edition to best answer these questions? Set clear goals and don't forget to define the non-goals, as well! This prevents *scope creep* (in short: adding features *ad infinitum*). Throughout this process, keep in mind that data operations and visualisations are a form of scholarship, too.

* Types of projects: digital textual editions
* Prerequisites for every edition project: research questions, goals and non-goals
* Managing the process: avoiding scope creep
* Logistics: coordinating team members and resources
* Sustainability: making your edition future-proof
* The scholarship of editions: data, interpretation, presentation

## Prerequisites

### Start from the outcome of your research questions and work backward

#### Don’t confuse "what" with "how"

What are your research questions?  
What are your outcome goals?  
How will you achieve those goals?

* **Example:** Instead of thinking that you need a database, think about what the database is supposed to do.

Who are your target audiences? To help answer this question, you can describe hypothetical *personae*. 

#### Don’t start with specialist consultants

* **Example:** Specialist consultants may think in terms of their specializations, and may recommend specific ways of doing things. Start with the research goals you want to accomplish.

#### Consider the balance between innovation and conformance

It’s your research, but scholarship happens in communities. Theoretically, you are free to set up your edition however you like, but you can prolong the success and longevity of your edition by taking into account prevailing standards, using existing tools and/or complying with agreements of specialist communities. 

* **Example:** The Linked Open Data (LOD) community expects your sources to be available at least 15 years, so complying to the standards of the LOD community implies making sure your data is persistently available. 

## Process

### Stages in the markup process

* document analysis
* schema development
* markup

#### Advantages of stages

* Where total time is fixed, stages keep you from expending all of your time on the early stages.
* Where individual resources are time-constrained (e.g., the consultant is available only at certain times), plan for it.

#### Limitations of stages

* Don’t keep pursuing a dead end. E.g., if you do all your markup before you do any processing, what if you only then discover that you should have done it differently? Or that you need a Relational Database Management System (RDBMS), and not markup at all?
* Don’t fall victim to *scope creep*. Pursue changes only when they’re realistic, and when you add something, omit something else to make room for it.
* The devil is in the details. Make frequent assessments from overview mode, and don’t get stuck in detail mode. 

### Stages aren’t strictly sequential

Don’t be this guy: “In Year 1 we’ll prepare our texts, in Year 2 we’ll process them, in Year 3 we’ll publish our results.” Why not?

### Stages or cycle?

Markup *stages* are really a markup *cycle*: 

*document analysis* → *schema development* → *markup*


## Logistics and resources

### Data resources

What are the data (or *capta*) and how will they be acquired or prepared?

*Data* is assumed to be a "given" that is able to be recorded and observed, while *capta* is "taken" actively. Capta is information that is captured because it conforms to the rules and hypothesis set for an experiment or, in this case, an edition (cf. [Drucker 2010](https://pdfs.semanticscholar.org/e0fe/227ff7a3822f5c0bd41cc566f1a472cc22f2.pdf)). This distinction clarifies the subjective process of acquiring and preparing data.

### Human resources

Time and human resource constraints? Technical (e.g., format) or management (e.g., license, privacy) requirements imposed by research context (funding agency, institutional policy, matrix project)?

### Toolkit

* Available and appropriate tools and contexts for acquisition, processing, analysis, and publication.
* Core technologies (e.g., RDBMS, XML, plain text, etc.)? 

## Sustainability

### Persistence, interoperability, extensibility

Integration with other projects? Planning for future growth? Data management or sustainability plan (required by funding agency)?

* **Example:** Linked Open Data (LOD) is meant for interoperation, and it takes your stand-alone project into a community.

### Encyclopedic information

Like every product of (textual) scholarship, your edition needs to provide encyclopedic information. 

* **Example**: Metadata, bibliography, prosopography (*personography*), gazetteer (*placeography*), etc. 

What information are you providing? How are you going to manage this information?  

* **Example**: Do you create master lists for an entire project, or do you create separates ones for (or within) individual documents? Is the information project-specific or do you refer to a third-party? What reference system do you use? Synchronization within and outside your edition?