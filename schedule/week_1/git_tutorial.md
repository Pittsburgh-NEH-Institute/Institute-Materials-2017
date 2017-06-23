# Git tutorial

Some introduction here

Git is content management system but not in the usual way you would expect from well known CMSes like Wordpress or Drupal.
For this reason git is called a content tracker.

# Set your indentity

When you start working with Git you need to set your identity. This identity will be used to track all the changes that you make to content in the repository.

* $ git config --global user.name "John Doe"
* $ git config --global user.email johndoe@example.com


# Working with repositories

To start working with Git you will need a repository.

Command | Description
------- | -----------
`git init` |   Create a new repository locally
`git clone` |   Copy an existing repository from a remote location (for example Github)

# working directory

When you navigate in the terminal over your files you are in what is called the working directory.
The complete repository with all the changes that people have ever made are still there in the background, outside of your working directory.
directory. 

# Making some changes

* Use your favorite editor
* PyCharm, \<oXygen/\>, vim, notepad++, BBEdit, etc.




# Working with changes locally

Command | Description 
--------|-----------------
`git status` | Shows which files are modified 
`git add`  |   Add a file to change tracking 
`git reset` |  Untrack a file 
`git diff` |  Shows changes
`git commit` | Make changes permanent
`git log`  | Show history of commits

# git commit

$ git commit -a (otherwise have to specify all the changes files as ready to commit)

Explain VIM (for MacOS and Linux users)

The use of the escape key in Vim, the 'i' for insert mode, :wq and :q! to cancel 


# How to revert files

there is a diffeence between files and commits

# Synching repositories

* `git pull`
* `git push`


# How to work with branches

Command | Description
--------|------------
`git branch`   |
`git checkout` |   Switch from one branch to another
`git stash`    |   Temporary move changed files out of the way




# Terms

* Repository
* Branch
* Working directory
* Fork (GitHub term)
* Pull request (github term)


Fork is remote repository on GitHub.
Branch is a thing in a repository
Git pull command is not exactly the same as a pull request on GitHub.

