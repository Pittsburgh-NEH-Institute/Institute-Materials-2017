# Git tutorial

Git is a content management system, but not in the usual way you might expect from well-known Content Management Systems (CMS) like Wordpress or Drupal, or well-known file-sharing systems like Dropbox or Box. For this reason, Git is called a *content tracker*.
Git is a content management system, but not in the usual way you would expect from well-known Content Management Systems (CMS) like Wordpress or Drupal, or well-known file-sharing systems like Dropbox or Box. For this reason, Git is called a *content tracker*.

What is needed to get started:

* a Github account
* knowledge of the command line

If you don't have a github account, create one.
Here is how you do that:

**TODO:** add url

Git is a distributed version management control system we are going to use remote repositiues located om a server on Github as well as a local repository located on your own machine.

During this tutorial we will be using the browser as well as a terminal window.

To administer remote Git repositories we use the browser, while in the terminal we will do everything regarding the local Git repository.

## Create a new Github repository

* Go to your browser
* Go to <https://github.com/>
* Log in to your account
* In the upper-right corner of any page, click , and then click New repository.
* In the Owner drop-down, select the account you wish to create the repository on.
* Type a name for your repository, and an optional description.
* You can choose to make the repository either public or private. Public repositories are visible to the public, while private repositories are only accessible to you, and people you share them with. We choose public for this tutorial.
* There are a number of optional items you can pre-populate your repository with. If you're importing an existing repository to GitHub, don't choose any of these options, as you may introduce a merge conflict. You can choose to add these files using the command line later.
	* You can create a README, which is a document describing your project.
	* You can create a CODEOWNERS file, which describes which individuals or teams own certain files in the repository.
	* You can create a .gitignore file, which is a set of ignore rules.
** You can choose to add a software license for your project.
* When you're finished, click Create repository.



Your repository will be located at `https://github.com/username/repositoryname`.





## Set your identity on your local machine

When you start working with Git you need to set your identity. This identity will be used to track all the changes that you make to content in a repository. You only have to do this once on each machine that you use.

Open a terminal window and type the following commands, replacing John Doe with your name:

* `$ git config --global user.name "John Doe"`
* `$ git config --global user.email johndoe@example.com`


## Working with repositories

Respositories are where you keep project files. To start working with Git you will need a repository.

Command | Description
------- | -----------
`git clone` |   Copy an existing repository from a remote location (for example GitHub)
`git init` |   Create a new repository locally

Now we need to get the remote repository that we just created.

* Create a directory in your user directory called Workspace were we store all the cloned repositories.

```bash
$ cd ~
$ mkdir Workspace
$ cd Workspace
```

Now we clone the repository that we just made on Github to the local machine.

```bash
$ git clone https://github.com/username/repositoryname
```

## Working directory

When you have a terminal window open, you are in what is called the working directory. The complete repository, with all the changes that people have ever made, is present, but in the background. Information other than current versions of your files is outside your working directory, but you can reach it when you need it.

## Making some changes

* Use your favorite editor to edit files (and you can use different editors for different files in the same project)
* PyCharm (for Python projects), \<oXygen/\> (for XML projects), vim, notepad++, BBEdit, etc.

## Working with changes locally

Command | Description 
--------|-----------------
`git status` | Show which files are modified locally
`git add`  |   Add a file to change tracking 
`git reset` |  Untrack a file 
`git diff` |  Show changes
`git commit` | Make changes permanent
`git log`  | Show history of commits

## Committing changes

`git commit -a` adds all changed files and commits the changes, that is, it combines `git add` with `git commit`. **But it only adds files that have changed, and not files that are completely new.** The only way to add a new file is with `git add`.

vim is the default editor in Git (on all operating systems). When you type `git commit`, you are taken into vim to enter a _commit message_, where you record information about the commit. The most important vim commands are:

You type | What happens
---- | ----
`Esc` | enter command mode
`i` | enter insert mode
`:wq` | write your changes and quit
`:q!` | cancel (quit without writing changes)

The use of the escape key in Vim, the `i` for insert mode, `:wq` and `:q!` to cancel 


## How to revert files

there is a difference between files and commits

# Synching repositories

* `git pull`
* `git push`


## How to work with branches

Command | Description
--------|------------
`git branch`   |
`git checkout` |   Switch from one branch to another
`git stash`    |   Temporarily move changed files out of the way


## Terms

* Repository
* Branch
* Working directory
* Fork (GitHub term)
* Pull request (GitHub term)


Fork is a remote repository on GitHub.
Branch is a thing in a repository
The Git `pull` command is not the same as a *pull request* on GitHub.

Synching

`git remote show origin`

`git add remote ... upstream`

Set the origin to the original repository (on GitHub; so clone the original repository)

To change existing origin: 

This is wrong:

	git remote add origin
	Error: already exist

This is correct:

	git remote set-url origin
	git branch --set-upstream-to=origin/master master

`git remote add myfork https://github.com/etc`
`git push myfork master` etc.

