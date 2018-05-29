# Pedagogical review and rationale

## Institute goals
* We aren't here to “tool up”, we're here to learn how tools work
* The central issue here is a philological one, not a digital one. Will your edition be based on your research question, or will it be a reading resource?
* Your edition should be intuitive to use, so you must predict where a user may want to go next from any given interaction point.

## Week 1: Bootcamp: Computational groundwork skills

### Basic computer skills and humanists

The bootcamp is based on two ideas: 1. Humanists can learn to program, and become adept at it and 2. Programming and encoding are vital to digital edition making. These two ideas ground all other topics taught in the three weeks. The work you undertake here is both achievable and necessary, and will help you what work a future edition will entail.

For that reason, we designed the bootcamp to cover basic, necessary skills that you will be able to build on, regardless of what tools you decide to use in the future. Python may very well be useless to you, but regular expressions work in Java (and plenty of other languages) as well. Your project may not have collaborators, but using GitHub gives you, the individual researcher, a unique advantage that Dropbox cannot confer: community. As we emphasized throughout, the bootcamp was not about “tooling up.” Rather, we hoped it would give you skills that would make “tooling up” for yourself easier later on in your work process.

The bootcamp was optional because some of you were already familiar with all the material it covered. There were benefits and drawbacks to this decision, and in future versions of this Institute, it may prove more useful to integrate this material in with edition work.

### Python

Python is the general purpose programming language most used by humanists. We assigned the tutorials to expose you to Python basics before the start of the Institute to get you familiar with the syntax. Not only did this make the logistics of reviewing and using Python later in the Institute easier, but it prepared you to see and understand the logic of other programming languages, even if the syntax differs.

### The mystery of the Internet

We understand that this topic is broad, and a truly useful investigation of this mystery would include a comprehensive history of the Internet, its creators, and its users. Sadly, that was not this lecture. Instead, we aimed to give you a basic idea of what the Internet is and how it does what it does, so that when you begin putting content on it, you understand how its getting there.

In the future, if you'd like to learn or teach more on this subject, we recommend starting with Rus Shuler's [How does the Internet work?](https://web.stanford.edu/class/msande91si/www-spr04/readings/week1/InternetWhitepaper.htm), which references other useful resources in its bibliography.

### Git and GitHub

We hope you will all continue to use Git to track and share your work. We emphasized this and other free, open-source technologies because we believe digital humanists should do their part to encourage free and open access to information. We hope, if the copyright status of your materials allows, that you will continue to work in public in the future.

We also hope you will continue to use (and promote) Best Practice for version control and project management in your future endeavors, as this can greatly increase your [bus number](https://en.wikipedia.org/wiki/Bus_factor).


##### Questions for feedback:
* Could the first week stand on its own as an independent course?
* How well did you feel prepared for weeks two and three?

## Week 2: Philcamp: Digital philology, creating a digital edition

### Text-as-Graph and LMNL

In practice, neither of these technologies are developed enough to use as markup strategies. They do provide an alterative to XML that makes you think about why you're modeling a text the way that you are. Does your markup ignore overlapping hierarchy when it could be addressing them with nuance? We did not expect everyone to grasp these concepts, or to be able to use Alexandria flawlessly, on their first try. Instead, we asked that you attempted to challenge your own ideas about what a text is and how it is structured.

### The Gothenburg model and CollateX

Collation is a big part of many traditional editions, but is often thought of as one step. The Gothenburg model separates computer-aided collation into five steps: Tokenization, Normalization, Alignment, Analysis, and Visualization.
These five steps are part of a computational pipeline, each of which takes input and creates output, which is then fed into the proceeding step.
This philological pipeline can be implemented without understanding the way individual steps work, which means team members can work on different parts of the project without interfering with others.

From a teaching perspective, this is advantageous for two reasons. First, collation is something many of you are probably looking to do as part of your research questions. Second, CollateX is a great example of a pipeline, upon which you can model other working pipelines in your projects. You can model pipelines other ways of course, but we happen to think this one is relevant and very cool.

### Text analytics with Mike



### eXist-DB and XQuery

Arguably these didn't become immediately relevant until the third week, but we tried to do software installation ahead of time (this meant putting out many fires, some fiercer than others). Ultimately, it was our intention to allow you time over the weekend to sit with XQuery before we dove into more difficult work in the third week.
As you begin to adapt these materials into your own teaching, please learn from our mistakes and budget your time for software installation better than we did.

### Questions for feedback
* How would you plan to model and teach pipelines?
* Did you find the pipeline development model was something you were already doing? How, and how does your new knowledge change that?
* In future versions of this Institute, what other examples of a pipeline might we be able to use?

## Week 3: Pubcamp: Expressing the edition, digital publication

Rather than introduce publication strategies that only allow you to pour your data into an existing model, we tried to emphasize technologies you could mold to your own needs. In some cases, this could be as simple as GitHub pages (especially when you're just starting out), or as complicated as a webapp in eXist-db. 
The week began with simpler technologies and moved to more complicated ones. This was a common approach throughout the Insitute, as we wanted to acclimate you to the kind of learning you were doing before we dove into complicated work. 
We don't expect you to remember everything you learned this week, especially because many of you are not yet prepared to publish an edition. For this reason, the materials used this week are available online. We've also emphasized a "Look it up" approach to problem-solving. 
This was not out of laziness or neglect, but stemmed from the belief that you'll have to do this stuff yourself, on your own, in a matter of weeks. In the mean time, we can help you learn to read error messages, stack traces, and help websites to glean the most useful information.

We intended the Pubcamp week not to teach you exactly how to publish your edition, but to show you a selection of options. In the future, you should do more research about which format might work best for you, and use our materials as reference in the event you need them.

### eXist-DB and XQuery (cont.)

Building a web app, API, and publishing an edition are all tasks that we understand are way in your future. We chose to teach them here because some of you may have projects already built that could benefit from updates, while others may be far off still. We did not teach these complicated publication technologies to demonstrate exactly how you should do it, but to show a mindful, balanced approach to publication. You should think critically about whether an eXist-db database is for you, and you should research other options as well. But we wanted to show the steps one takes in making that decision and learning to implement it.

We hope that you got everything you could from the XQuery lessons. We saw many people struggle, and then triumph after much hard work in review sessions. Know that this will be something you can expect throughout your career as a digital humanist, and that teaching technologies to others will improve your skills with them even more.

### Lightning talks

We hope you all enjoyed one another's lightning talks. It was wonderful to see how much everyone's ideas have evolved. We included lightning talks as a way to integrate your editions and your ideas into the day-to-day of an Institute that could sometimes be very abstract. We hope the lightning talks afforded you the chance to collaborate and discuss ideas openly with other participants, and to bounce ideas off instructors as well.

Lightning talks were part of a more general emphasis on the social aspect of the Institute. Your evening sessions and reviews together in Bouquet Gardens were meant to happen, though they appeared organically. The diversity of intellectual discipline in attendance was purposeful. Many institutes like this bring together scholars from only one field or subfield. While this is a sensible way to run an institute, it does not promote networking, collaboration, or problem solving in the same way this community does.

### Licensing and archiving

Issues of licensing and archiving are significantly more complicated when you publish independently. Automatically, you own the copyright to anything you create. But you might not own the materials you're using in your edition, which can become complicated very quickly.
We don't touch on those issues much here, though they're a considerable hurdle for any edition-making project. We don't go into much detail because everyone's case is different, and you have to research your particular case on your own.

Instead, we offered an overview of the issues and how one might research to resolve them. We also encourage you to use Creative Commons licenses in the spirit of collaboration and building community.

## Conclusions

Thank you all for such a wonderful NEH Institute experience! Individual instructors will make their remarks, please feel free to ask questions as they do.
