# Your own copy of the Institute GitHub repository

**Git** is a version control and general project management tool. **GitHub** is the social face of Git: you’ll use it to store your project files, share them with your project partners, keep track of revisions, and (typically) make them accessible to a broader community.

Files you use for Institute activities are located in our GitHub repository (*repo*), and in order to work with them, you’re going to create your own copy of the repo, called a *fork*. This page explains how to do that.

## Before you start: GitHub hygiene

All work in Git happens on your local machine, and you *push* changes to GitHub to make them available to others, and you update your local working copy by *fetching* or *pulling* changes that others (including yourself on a different machine) have put on the repo. If two users edit the same parts of the same file at the same time, GitHub won’t know which version to trust, so it will generate a *merge conflict*, which you have to resolve manually. Most merge conflicts arise from poor GitHub hygiene, which you can avoid by following these precepts:

* **Pull when you start.** When you begin a working session on a project in Git, start by pulling from GitHub, that is, copying all changes that might have been uploaded by someone else. Don’t do any work until you’ve pulled.
* **Push when you stop.** When you finish a working sessions, push (upload) your changes. Don’t go to sleep at night without having pushed.
* **Push often.** When you complete a discrete task during a working session, push your changes before you continue your work. The longer you wait (within reason) between pushes, the greater the opportunity for a project partner to edit the file you’ve been working on, which can cause a merge conflict.
* **Do all work in your local repo.** Don’t edit files on GitHub in the browser and don’t upload or download individual files, even though GitHub will let you do both. Do all work in your local copy, synchronizing it frequently with GitHub.

If you do encounter a merge conflict, see [Painless merge conflict resolution in Git](http://blog.wuwon.id.au/2010/09/painless-merge-conflict-resolution-in.html). But it isn’t really painless, and the best way to deal with merge conflicts is to avoid them by following the guidelines above. Don’t be [this guy](https://xkcd.com/1597/)!

## Install Git

Information about installing Git on your own machine is available at <https://git-scm.com/book/en/v2/Getting-Started-Installing-Git>. 

## Create a GitHub account

Create a GitHub account at <https://github.com/>.

## Set up your identity

When you start working with Git on your local machine for the first time, you need to set your identity, which makes it possible for you to interact with your project repository (*repo*) on GitHub. To set up your identity on your local machine, execute the commands below. Your name and email must match the ones you used when you created your GitHub account. You only have to do this once on each machine that you use. 

```bash
git config --global user.name "John Doe"
git config --global user.email johndoe@example.com
```

## Fork the Institute repo

You’ll read and process files that we’ve put into the Institute repo, and you’ll also create your own files. You don’t have permission to write into our repo, so you’re going to create your own *fork*, a copy of the repo that you control, and into which you can write. Your fork will live both on GitHub and on your local machine; you’ll work on your local machine and push your changes to GitHub.

The main repo for the Institute is at <https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017>. Navigate there in your browser, click on the button that says  “Fork” in the upper right corner, and GitHub will create a fork (a copy of our repo) in your GitHub account. You now have your own copy of the repo in GitHub, but it isn’t yet on your local machine.

## Clone your fork

*Cloning* is the process of creating a local copy of a GitHub repo. Yoou’ll do your work in that local copy and then push your changes to your GitHub fork. <!--You could have cloned the main Institute repo instead of forking it and then cloning your fork, but the advantage of cloning your own fork is that you can create or change files and push them to GitHub, which you can’t do with the main Institute repo because you don’t have write permission-->

To clone your fork, navigate to it on GitHub and click on the green button on the right side labeled “Clone or download”. Copy the text in the little box that begins with “https”. Open a command line session on your local machine, navigate to the location where you want to create your local copy (you can use your Desktop if you don’t have an alternative preference), and type:

```bash
git clone https://github.com/...
```

replacing the part after the word `clone` with the text that you copied from GitHub. When you git the `Enter` key, git will create a local clone of your fork as a subdirectory of wherever you executed the command.

## Keeping your fork synchronized with GitHub

Do all of your work on files in your local copy of your repo, synchronizing it with your fork on GitHub frequently. For a guide to pushing to and pulling from GitHub, see our [Git tutorial](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_1/git_tutorial.md).

## Telling your clone about the main Institute repo

When you push to and pull from GitHub, you’re synchronizing the copy of the repo on your local machine with the one in your fork on GitHub. When you first created your fork, it was an exact copy of our repo, but it doesn’t automatically keep up with changes we make. In GitHub terminology, assuming you haven’t created other branches, your local repo is your local *master*, your fork on GitHub is *origin/master*, and our repo on GitHub is *upstream/master*. Your local copy knows about *origin/master* because that got configured automatically when you cloned your fork, and that’s where you push and pull by default. But it doesn’t know about *upstream/master* until you tell it. You can do that by running the following command:

```
git remote add upstream https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017.git
```

The meaning of the preceding command is explained at [Configuring a remote for a fork](https://help.github.com/articles/configuring-a-remote-for-a-fork/). You only have to do this once inside each clone you make on a local machine.

## Keeping your fork synchronized with our repo


Once you’ve told your local clone about the upstream remote, you can fetch and merge from it any changes we may have made since you first created your fork. For instructions about how to do that, see [Syncing a fork](https://help.github.com/articles/syncing-a-fork/).

Remember that you can’t push your local changes to our original repo because you don’t have write permission there. You can pull from both your GitHub fork (*origin/master*) and our repo (*upstream/master*), but you push only to your own repo (*origin/master*).

## For more information

For more information, see our [Git tutorial](../week_1/git_tutorial.md) and our list of links to [Git and GitHub resources](../week_1/git_resources.md).