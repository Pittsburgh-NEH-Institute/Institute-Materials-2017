# Pedagogical review and rationale

## Institute goals
* We aren't here to “tool up”, we're here to learn how tools work
* The central issue here is a philological one, not a digital one. Will your edition be based on your research question, or will it be a reading resource?
* Your edition should be intuitive to use, so you must predict where a user may want to go next from any given interaction point.

## Week 1: Bootcamp: Computational groundwork skills

### Basic computer skills and humanists

The bootcamp is based on two ideas: 1. Humanists can learn to program, and become adept at it and 2. Programming and encoding are vital to digital edition making. These two ideas ground all other topics taught in the three weeks. The work you undertake here is both achievable and necessary, and you are the only person qualified to determine what that work will entail.

For that reason, we designed the bootcamp to cover basic, necessary skills that you will be able to build on, regardless of what tools you decide to use in the future. Python may very well be useless to you, but regular expressions work in Java (and plenty of other languages) as well. Your project may not have collaborators, but using GitHub gives you as an individual researcher a unique advantage that Dropbox cannot confer: community. As we have emphasized throughout, the bootcamp was not about "tooling up." Rather, we hoped it would give you skills that would make "tooling up" for yourself easier later on in your work process.

The bootcamp was optional because some of you were already familiar with all the material it covered. There were benefits and drawbacks to this decision, and in future versions of this Institute, it may prove more useful to integrate this material in with edition work.

### Python

Python is the general purpose programming language most used by humanists. We assigned the tutorials to expose you to Python basics before the start of the Institute to get you familiar with the syntax. Not only did this make the logistics of reviewing and using Python later in the Institute easier, but it prepared you to see and understand the logic of other programming languages, even if the syntax differs.

### The mystery of the Internet

We understand that this topic is broad, and a truly useful investigation of this mystery would include a comprehensive history of the Internet, its creators, and its users. Sadly, that was not this lecture. Instead, we aimed to give you a basic idea of what the Internet is and how it does what it does, so that when you begin putting content on it, you understand how its getting there.

In the future, if you'd like to learn or teach more on this subject, we recommend starting with Rus Shuler's [How does the Internet work?](https://web.stanford.edu/class/msande91si/www-spr04/readings/week1/InternetWhitepaper.htm), which references other useful resources in its bibliography.

### Git and GitHub

We hope you will all continue to use Git to track and share your work. We emphasized this and other free, open-source technologies because we believe digital humanists should do their part to encourage free and open access to information. We hope, if the copyright status of your materials allows, that you will continue to work in public in the future.

We also hope you will continue to use (and promote) Best Practice for version control and project management in your future endeavors, as =this can greatly increase your [bus number](https://en.wikipedia.org/wiki/Bus_factor).


##### Questions for feedback:
* Could the first week stand on its own as an independent course?
* How well did you feel prepared for weeks two and three?
* 

## Week 2: Philcamp: Digital philology, creating a digital edition

### Text-as-Graph and LMNL

In practice, neither of these technologies are developed enough to use as markup strategies. They do provide an alterative to XML that makes you think about why you're modeling a text the way that you are. Does your markup ignore overlapping hierarchy when it could be addressing them with nuance? We did not expect everyone to grasp these concepts, or to be able to use Alexandria flawlessly, on their first try. Instead, we asked that you attempted to challenge your own ideas about what a text is and how it is structured.

### The Gothenburg model and CollateX

Collation is a big part of many traditional editions, but is often thought of as one step. The Gothenburg model separates computer-aided collation into five steps: Tokenization, Normalization, Alignment, Analysis, and Visualization.
These five steps are part of a computational pipeline, each of which takes input and creates output, which is then fed into the proceeding step.
This philological pipeline can be implemented without understanding the way individual steps work, which means team members can work on different parts of the project without interfering with others.

From a teaching perspective, this is advantageous for two reasons. First, collation is something many of you are probably looking to do as part of your research questions. Second, CollateX is a great example of a pipeline, upon which you can model other working pipelines in your projects.

### Text analytics with Mike



### eXist-DB and XQuery

Arguably these didn't become immediately relevant until the third week, but we tried to do software installation ahead of time (this meant putting out many fires, some fiercer than others). Ultimately, it was our intention to allow you time over the weekend to sit with XQuery before we dove into more difficult work in the third week.
As you begin to adapt these materials into your own teaching, please learn from our mistakes and budget your time for software installation better than we did.

## Week 3: Pubcamp: Expressing the edition, digital publication


