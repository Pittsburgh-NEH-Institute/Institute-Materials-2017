Git tutorial part 2

## How to work with branches

Command | Description
--------|------------
`git branch`   |
`git checkout` |   Switch from one branch to another
`git stash`    |   Temporarily move changed files out of the way

## Forking repositories on Github

Note: has to do with permissions.

A fork is not a branch.


Syncing

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





## Terms learned part 2

* Branch
* Fork (GitHub term)
* Pull request (GitHub term)

## Notes

Fork is a remote repository on GitHub.
Branch is a thing in a repository
The Git `pull` command is not the same as a *pull request* on GitHub.
