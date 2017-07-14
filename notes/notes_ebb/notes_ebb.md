NEH Institute July 2017

Materials:
https://pittsburgh-neh-institute.github.io/Institute-Materials-2017/admin/

Schedule info (beta?):
https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/tree/master/schedule


Getting to know your Mac session:
—folders in Finder are named differently in another language—meant to be convenient. “What you see in the Finder window is a little bit of a lie.”

Observation: when you ls at command line, the organization is case sensitive, as it is not in Finder window (so lower cased files with letter “a” appear after those beginning with “Z”.

cd / 
gives you the root of the file system

root = (when its the owner of a file directory— it is the ultimate super-user that owns / sets up your machine. Has all permissions. (Having root access = having root control and needs to pass no permissions barriers)

drwxr-xr-x@  4 root  wheel   136 May 25 02:05 System  
The d in the front means “directory”

-rw-r--r--
The hyphen means it’s a file

cd / 
cd/Users/ebb8/Downloads

/ at the beginning = the root
when / is inside the path, it means go inside. 

-rw-r--r--@   1 ebb8  staff      12441 Sep 19  2016 1601variant.xml
The 12441 is the file size

Try ls -lh
(means list long and human readable):
(Gives you file sizes in KB or MB): 

permissions:
drwx------@  7 ebb8  staff   238B Jun 30  2016 SaxonHE9-7-0-6J
drwxr-xr-x@  4 root  wheel   136B May 25 02:05 System

directory user can read/write/execute; group (what can they do?), anyone else (what can they do?)

Leif sez: wheel group indicates whether you can connect to input/output devices (like mobile connections)

x-bit, the x at the end means it’s executable: what are you (as a user, group member) allowed to execute?

directories need an x-bit so that we can *enter* them. If they lack this, you can *see* it’s there but can’t get inside.

drwxrwxr-x means it’s a directory that the user and group can read, write, and execute, and everyone else can read and enter (but NOT write to)

The @ symbol at the end means special permissions attributes, and it’s Mac specific (won’t have anything like it on a Linux or a Windows system)

command line NEVER hides the file extension. (Tara indicates how you can show/hide these on yr mac). 

cd by itself takes you back to your home directory

ls -l dev
ls -lh dev

dev null is where you send things that you want to throw away, and Tara emphasizes this can be EXTREMELY useful
c in it and other paths means “character device”— and with null it “takes this character and throws it away” (which is why sending to dev null throws stuff away)

Stuff in /dev talks to your printer, your USB drive, your network, etc.


file
in front of a path: command gives you information about the file

When there are white spaces in filenames, you escape it with \ 
so in a path to a directly 2016 WS, add 2016\ WS

You can also drag and drop a file path into the Terminal 


WHEN I STICK A USB DRIVE IN…
on Windows it goes to a new drive name
but Mac doesn’t do that

cd /Volumes shows your various mounted disks
That means that cd /  and cd /Volumes/Macintosh\ HD show you the same thing


When you drag and drop in the Mac Finder — It MOVES when it’s in the same volume
But it COPIES if you move between volumes

cat
opens a file at the path give in the terminal window

sudo = superuser can do it

*****

David’s portion: 
He uses a different terminal called 
https://www.iterm2.com/

It’s an alternative to Terminal, but doesn’t replace it. (You can still use the old terminal)

He’s having us work in etherpad.net to do communal note-taking

bash shell  means “born again shell” —made by a guy name Bourne(?)

pwd = print working directory


ASCII 
is a seven-bit character set
It has seven bits that can be read as 0 or 1



Notes NEH-Institute "Make Your Edition"
Day 1 // July 10, 2017


Alternate Terminal David Used in Session
We can check out this alternative to Terminal on our own time:
* https://www.iterm2.com/
    
    
Terminal Commands
* bash shell  means “bourne again shell” —made by a guy name Bourne(?)
* pwd = print working directory
* clear  or hotkey: CTRL + l  or clear: clears the screen
* whoami: tells you who you are, in times of amnesia

~ 
a shortcut for your home directory  
~/Users = your-home-directory/Users
~ as alias for home directory. "Ex: cd ~/Documents" will take you to your Documents directory no matter your current location.

ls -F 
(The "F" stands for file information).
shows you clearly which files are plain files and which are directories (shows some file information)

ls -l
long listing

ls -lh 
long listing human-readable 
NOTE: Windows people may see that directories look empty (size 0), while Mac / Linux people see directory sizes

ls t*
lists all the files that begin with t from this point into files in subdirectories

ls *sample
lists anything followed by sample

ls sample* 
lists anything beginning with sample 

ls -d
("don't recurse")= don't look deeper than this current directory

Case sensitivity may be problematic. Please be consistent and aware.

ls -a
shows you all files including the hidden files, alphabetized first upper case, then lower case

ls -lt
sort files by time stamp (by is it modified or changed, or last access??)

ls -ltr
sort by timestamp in reverse order, so newest file is at the bottom

ls -lG
gives you colorized output!
But we can make an alias that points to this, and runs it by default when you hit ls -l

ls -1
forces output list into single-column format

ls -d */
shows ONLY the directories

ls -R 
lists recursively contents of all subdirectories

CTRL + c 
interrupts a long process, returns to prompt

cd
by itself, sends you to the home directory

cd ..
one level up (towards root) (or down, depending on your conception of the tree ) 

cd -
go back to where you just were before you changed directories

cd ../..
goes up to the parent of my parent

pwd 
gives path you're on 

tab
autocompletion
hit tab twice to get the options.

hitting the up arrow key
displays the last command you typed. Hit it successfully to return previous commands. 
down arrow sends you back to the commands closest to present. 

REVISE previous command
up arrow
control + a moves cursor the beginning of the command
control + e moves cursor to end of the command

mouse cursor isn't the same as the command line cursor
but if you hit the OPTION key, you get mouse control at that point

control e + control u cleans up a full command 

history
gives you the full list of your commands

!! 
executes your last command (be careful!)

!574   (or !givenNumber)
executes command number 574 (or !givenNumber) in your history 

man command
* 		e.g. 
* 		man ls
* 		opens the manual for a particular command
* 		Type q to get back to a command prompt

While you're in man
to land on something with a particular letter:
    space key: moves you a page at a time
       ? : moves you back
    
    /g  
    looks ahead for stuff with the letter g
    ?g
    looks backwards for stuff with the letter g
    G takes you to the end

GOOD FILE HYGIENE
no whitespace in filenames
puncutation in file names should only be . - _

Be consistent in your file name conventions (be aware of upper and lower case and how they come out in ls)

Side notes:
David practises "poor directory hygiene". Many of us do. 
Is it poor directory hygiene, or comprehensive curation?

Directories are files (special kinds of files)


Tara's Segment

mv from .jpg to .txt, the command line will tell you with the file command that it's really a jpg file *regardless* of the file extension you've attached to it. 

less filepath/file.extension
shows you the file

Alice in Wonderland text comes out looking like an ICE file b/c ICE is recognized by having the characters ICE offset by two 
(so the command line identification of filetype is not infallible)


ASCII 7-bit --limited to latin alphabet...if you want more complexity...you need that 8th bit


8-bit character sets:

if you need 'Czech marks"... you needed a distinct character set...had to change from Western European to Eastern European to Turkish, etc

Chinese has MANY more than 256 characters! so 8-bit character sets are insufficient
You needed CJK encoding...to reserve 2 or 3 bytes for each character to get everything in: it was called "double-width encoding" b/c each character took "double the width" of bytes compared to European encoding.

font layering was a 1990s workaround...it's okay for looking atthe txt. but if you try to search for it, the Latin and Cyrillic will be mixed up in searches: they're sharing the same 8-bit charaacter set.

Unicode was designed to deal with this problem
Unicode lines up with ASCII's hexadecimal notation 
A in Unicode is 0041
A in ASCII hexadecimal notation is 41

Unicode goes up to 4 bytes

to go from bytes to numbers you need to know more than whether it's Unicode...you need to know how it was encoded(?)
Problem with mapping ASCII characters to Unicode 4-byte encoding--produces garbage b/c ASCII characters don't take up the same space to find the end of the ASCII characters...

Variable length encoding: UTF-8 aligns with ASCII : UTF-8 is backwards-compatible with ASCII

Mac  / LInux: 8-bit characters (UTF-8)

Windows: saves Unicode files in UTF-16

Difference character set - font

character maps
number to *conceptual* letter
vs.
font: mapping of number to shape (or glyph)

iconv
a command line utility that can remap the characters when you have legacy files

iconv -f
-f = what file encoding you're coming from

iconv -f ASCII -t UTF-8 message.txt > messageConvertedUnicode.txt

CRLF line terminators:
    --from typewriters: carriage return! vs. line feed 
    All Windows-encoded texts have a carriage return and a line-feed at the end of a line
    
ASCII CR is 13
LF 10

Over on Mac and Linux, they thought, come on, there's no reason to use two characters at the end of the line--
CR said the Macs!
LF said the Linuxes!

xxd filename.ext
shows you the character encodings in your document

ASCII characters go from 0 to 127

characters 128 on, need 2 bytes
0 to 128, and then 128 to 2^14 

The leading numbers in a UTF-8 character tell you its size and what kind of character it is

Big-Endian vs. Little-Endian

UTF-16 always needs 2 bytes
some computer architectures read right to left, others go left to right.
You need to signal to your computer the byte order

byte order mark (bom)
* 		FE FF 
* 		in binary, that's 11111110 11111111
* 		The computer knows it needs to read FE FF, and it tests left to right, or right to left until it reads FE FF
* 		 
* 		You NEVER need a bom in UTF-8. b/c you ONLY read the bytes in one direction in UTF-8
* 		 
* 		But when a Windows user saves a UTF-16 file to UTF-8, it outputs an unnecessary (and confusing) bom mark, bound to confuse Mac and Linux systems
* 		 
Big Endian simply means the big number in FEFF comes first. 

Anatomy of a shell command:
    first word is the command
    most everything else (with the exception of >) are arguments

Notice when reading error messages in shell: where's the error message coming from? 
Is it the bash shell? Is it the command itself? 
iconv: turkish_text.txt No such file or directory (That error message was generated in the process of executing the command)
bash: ls-l: command not found  That error message was generated by the bash shell, and it means it doesn't recognize the command

Twitter hastag for the institute:
#MakeYourEdition2017





TUESDAY JULY 11
Regex
I learned:
\b and \B
\b marks a positional boundary around a string:
	if you need to find them but not anthem or themselves, set the \b around it:
	\bthem\b
If you want it all connected—ONLY anthem and themselves, but NOT them, do it with \B
	\Bthem\B

*******
More stuff in Etherpen
********



David’s Command Line Tutorial:

Command Line (David)
less 
lets you see a screen of text
/  lets you search when you're in less
"bang dollar sign"
!$ last argument of the last command in your history

control + r 
  starts a reverse history search

control + c 
* 		clears your shell
* 		 
mkdir filename.ext
* 		makes a directory with the name you indicate
* 		 
rmdir filename.ext
* 		removes the directory (only empty directories)
* 		 
touch filename.ext
* 		makes an empty file

rm filename.ext
* 		removes file (be careful!)

glob (NOT ITSELF A COMMAND, but a KIND of command)
* 		similar to but annoyingly different from a regex
* 		you get two wildcards
* 
     globs any string, any number of characters
*? 
* 		globs any single character
* 		 
rm -i *
* 		interacts with you, asking for each file before deleting

rm -r directoryname 
* 		totally removes directory and all its contents and subcontents, etc
* 		DON"T DO THIS AT YOUR DESKTOP!!!! or your DOCUMENTS (ARRRRGH!!!!!)
* 		 
How to copy and rename files:
    
cp file1.txt file2.txt
* 		copies and renames file1.txt to file2.txt

cp file1.txt ../backup/
* 		copies files 1 into a directory up to parent and down into backup directory
* 		 
cp -a 
* 		switch keeps the original timestamp when you copy 

Fun with Globbing:
    ls *17*
* 		    gets you all the filenames with a 17 in them
* 		you could find 
ls -al
* 		shows the pointers to the current directory and its parent (won't see this on PC, but you will on Mac and Linux)

Find what DOESN'T have a character
ls *[^AB].txt
* 		find all the filenames which DON'T end with an A or B
ls *[AB].txt
* 		find all the filenames that end with A or B
* 		 
Pipelines
* 		a Unix philosophy, opposed to the black box approach
* 		you control every step
* 		input is read by a handle 
* 		3 file handles
* 		standard in
* 		 standard out
* 		standard error
Filters read from standard input (comes from the screen), write to standard output. Output goes to your screen. Error message goes to standard error and ALSO goes to the screen

cat 
* 		concatenate
* 		normally spits file content out onto the screen
Send cat to a file: Use output redirection:
    >
    This redirects the output from the window into a file
    
You can concatenate a bunch of files, like so:
     cat NENE* > redirected.txt
    (grabs all the files starting with NENE, and directs them into ONE file)
    The cat process is still just writing to magic out, and the shell with redirect just moves that output away from the screen
    
wc 
* 		gives a word count
* 		of a file, or of a whole directory (when you don't give it a filename argument)
* 		 
wc -l 
* 		gives only the line count
wc -w 
* 		gives only the word count

The pipe:
    cat ethane.pdb | wc
here, the cat sends to standard output, and the shell sends that output to whatever is after the pipe
Shell passes the argument to cat
cat writes the contents of the file to standard out
wc gets its input from the pipe and returns the output
You can chain these as long as you want

Check it out: 
    cat ethane.pdb | wc > count.txt
(Three stages, separated by | and >

ls -l | head
* 		gives you the first 10 lines of what you asked
* 		 
ls -l | tail
* 		gives you the last 10 lines of what you asked
* 		 
ls -l | head -5 
* 		gives you the first five

ls -l | tail +2
* 		bumps you up two lines from the end...and you could go add a head to that...

ls-l | tail + 2 | head

Sorting

sort with a pipeline:
    ls -1 | sort -r
* 		

Programs and Files 2 (Tara)
* 		https://pittsburgh-neh-institute.github.io/Institute-Materials-2017/schedule/week_1/programs_and_files2.html

Variables in Bash
q=42.5; echo $q

notice, no white spaces. 
$ indicates the value, so don't use it in assignment. 

bash variables you set are localized to the particular shell you are running

Write a bash script:
    write a file with a bunch of bash commands. Save it and run it in bash.
    when you run it, its context is temporary---your variables only execute in that context

Environment variables are bits of info in your environment, sometimes in bash, sometimes your OS as a whole. It depends on which bits of your environment are looking at what information.

Bash has lots of enviornment variables. To view them, enter 
set

"Your Java home is not defined"
--means it's missing an environment variable that indicates a location for Java

You pass arguments to variables

Editing environment variables: they are almost always block caps
BLOCKSIZE
* 		you can change it so it's optimized for a particular session, but it'll change back or won't last afterwards
* 		changes (temporarily) the storage of blocks of information/ files across available memory blocks

unset variable
* 		removes it

can export it to keep it. 

export BLOCKSIZE=1024; ls -s

your $PATH is where your computer looks for places to find how to understand the environment variables you're entering
(This is how $PATH knows how to run git when you have it properly installed)

$PATH variable has r-xr-x-r-x permissions: readable and executable. bash can't run any program unless you have this set

which
* 		how you find where something is on your $PATH
* 		By default this gives you the *first* properly executable version of a program you ask for. 
* 		If I want ALL of them, say
which -a

Mac people:
    BBEdit .bash_profile
* 		    brings up your BBEdit window showing your .bash profile, and this is where you can set your aliases, and add some things to your environment variables
* 		 
* 		Anaconda will set itself at the beginning of your $PATH so it'll default to the latest version (instead of the native 2.7 on your system).
* 		 
More Tricks with Your Environment

language of your system = a series of variables known as your locale


What variables you set in your bash profile will stick the next time you open your bash shell
(Same goes for aliases)



BLOCKSIZE=1024 ls -s *.txt | wc -c > result.txt

# comments out a shell command

CONTROL + D usually ends what shell you're in

umask 
* 		changes the default file permission settings
* 		 
When you change your bash profile, go and reopen Terminal, b/c Terminal will be reading from the old bash profile until you do.

Some people change their command line prompt (say to tell the time and day, deliver a message, write a random comment like Tara's)

pandoc 
* 		a Swiss army knife of file converters
INSTALL IT TONIGHT.

Also, for Mac users: homebrew fortune 

ay 3 // July 12, 2017

Regular Expressions #2 (Leif)

https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_1/regex2.md
https://pittsburgh-neh-institute.github.io/Institute-Materials-2017/schedule/week_1/regex2.html


Lizzy suggests >> http://programminghistorian.org/

repetition takes precedence
then grouping
then concatenation

directory name egrep -r "expression" --color directory/
* 		this will show the file path in results so you know where the matches occurred
* 		(question: does "file name" refer to where you are, or do you give a file name? I think the > should be $?  yes, it means the current directory.
* 		 
Example:
    egrep -r "\(.+?\)" --color .
    (The dot is for the directory you're standing on)
    NOTICE: no pipe.
    If you put the directory path first and set a pipeline with |, you'll just get literal results, but not preceded by filenames in your directory
    
http://www.regular-expressions.info/backref.html

https://regex101.com 
Use this to test regular expressions, and see an explanation of what they do. Also see how they come out in different environments (Python, JavaScript, etc)

egrep -i  
* 		-i flag to set case insensitivity
* 		 

sed 
* 		stream editor: a means by which one might make replaces with egrep regexes
* 		 
sed -i  'regex-to-find'//'regex-to-replace'g
Windows example:   sed -r   's/regex-to-find/replacement-regex/g'
* 		But you don't write out the word "replacement", do you? No but it can be just a string or a regex
* 		sed regexFind//regexReplaceg 
* 		(I think that's the format?)  I thought just one slash I think it's two.. ?Maybe its a windows/mac diff?.. Also, are quotation marks required?  They're necessary for me on windows :)  (It's really hard to read the fuzzy screens they're projecting on)
* 		g = global, across the whole string (otherwise it stops at the first regex match

* 		means do the replace in an input file. 
* 		you can also read in expressions from a file, and operate on another file
* 		On Windows, you have to specify -r with sed to work with regex

Useful link for sed command: http://www.grymoire.com/Unix/Sed.html
 
More Command Line (David)
https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_1/command_line_3_djb.md
square brackets in source reports (when we see error messages in shell) indicate that flags are optional

copy directories by copying recursively:
    cp -r backup extra-backup
    
If you copy a directory over a destination that exists, the original stays in place and holds the new copy in it as subdirectory

mv 
* 		used to move, or rename a file in place
* 		mv pizza.cfg pie.cfg
* 		works to rename a file
* 		 
* 		 
* 		mv pie.cfg directoryPath
* 		moves the file, keeps the same name, into designated directory
* 		 
* 		 
* 		mv pie.cfg ../pizza.cfg
* 		moves and renames 

rm
* 		removes a file
* 		 
for-loop

* 		for file in *; do echo $file; done

; 
* 		indicates command separator (we could use a line break in writing this out with secondary > prompts). We could enter this on multiple lines and not use the semicolon at that point. When this collapses on one line, the ; comes in there.
* 		 
echo -n 
* 		gets you multiple results all on one line (not separated by newlines)

quotation mark sensitivity!
shell  variables can be expanded inside double quotes, but they are NOT interpreted inside single quotes!

{ }
* 		protect the variable...always good practice, even if you're not sure you need it




[Questions for Later: How do I work with stuff in the less view. as in grep/regex/etc?) Perhaps one doesn't?]
[is there a way to make that 'rm *.bak ' safer? I thought maybe there was, like typing *.bak first then rm? Or commenting the line then deleting the #? Or am I being over cautious?!
* 		- suggestion at lunch was to set rm = 'rm -i' as an alias first

You can also use the "-i" switch with "rm" on the command line without having set an alias. For example:
    
    rm -i *.bak

will double-check with you before deleting the files. "rm" isn't aliased, so it will have its unsafe behavior if you use it by itself later, but you'll have made it interactive for this particular invocation.

I wonder why we didn't do that rm with a loop?
David's Answer: Do this when you can safely run a global operation. 

Mac users can install pcregrep, which is an additional grep-like utility that supports look-ahead and look-behind. To install this, first install Homebrew (a package manager) and then run "brew install pcregrep". After that, "man pcregrep" will provide the usual man page. The activity we did at the end of the day can be run with:
    
    pcregrep 'q(?!u)' enable1.txt
 
Day 4 // July 13, 2017
 
How the Internet Works (Tara)
https://pittsburgh-neh-institute.github.io/Institute-Materials-2017/schedule/week_1/internet_1.html

"like magic"

Hostnames and DNS
http://digwebinterface.com (for Windows users)

host  
* 		returns IP address of a given domain name

dig
* 		returns lots more information: on the authority providing the domain name and the hosting providers
* 		It's a good idea for name servers to be distributed across multiple server locations--not all in the same machine room

dig domain ns
* 		as in
* 		dig www.ox.ac.uk ns
* 		 
* 		ns = name service
* 		ISP = internet service provider
* 		IANA = internet assigned numbers authority: https://www.iana.org/
* 		 
Internet Addresses
* 		 
ipv6  vs. ipv4  
* 		ipv4 is shorter b/c it goes to 2 ^ 32 digits, and we've actually run out of possible numbers
* 		ipv6 goes maybe to 2 ^ 64 (?) . We'll start seeing more of these. They're marked as AAAA records rather than A networks. 
* 		 
A records == also called pointers

For an IP address to be referred to by multiple names: 
    you need CNAME
        
Private ipv4 ranges:
* 		example: routers at someone's house. They have 4 x's, and serve a small range of numbers. They're meant to be localized within a house, for example. Not a public-facing web server. NAT (?)
* 		 
Be careful for public ipv6: not everyone may be able to reach you...
* 		https://en.wikipedia.org/wiki/IPv6_deployment  "As of May 2017, Google's statistics show IPv6 availability of approximately 16% amongst its users. It is used more on weekends[2] and adoption is uneven across countries and Internet service providers."
* 		 
Network Communication
Ports
* 		What is "listening" on a port
* 		Ports are a list of numbers. Run a program that listens for traffic, it listens over a port that's bound to a particular number
* 		binding ports to particular numbers
* 		To see the list of ports:
* 		less /etc/services
* 		 
grep -v '^#' /etc/services | wc -l
* 		Review: 
* 		returns a count of services that do NOT begin with a hashtag (-v flag on grep gets the complement)

Network Protocols
HTTP 1.1
* 		protocol that permits a server to serve multiple websites (different domain names)
* 		On telnet, when you GET / HTTP/1.1  , you need to specify the host name.
* 		 
* 		telnet whatismyipaddress.com 80
* 		GET / HTTP/1.1
* 		Host: whatismyipaddress.com
* 		  
 
dig well.com mx
* 		mx returns info about the e-mail service at this domain
* 		 
Reverse DNS lookup
* 		look up an address and return its domain name
* 		 
ifconfig en0

General Shell Observations
enter wc by itself at prompt
* 		cursor returns waiting...That's not hanging and it's not an error.
Type stuff in mutliple lines and hit Control + D
That signals ending and exiting, so the shell can run your standard input over multiple lines.



Git 1 (Ronald)
https://pittsburgh-neh-institute.github.io/Institute-Materials-2017/schedule/week_1/git_tutorial.html

Why not just use Dropbox etc?
* 		Dropbox = immediate syncing of cloud with local
* 		only ONE truth

Why use Git?
* 		Git is distributed version control
* 		all local file histories are stored and DISTRIBUTED across multiple systems
* 		MANY truths
* 		NO CENTRAL AUTHORITY, and therefore no single point of failure
* 		 
It's a version management system
* 		You want to use a version mgmt system b/c you might destroy something you need to recover. You can recover things to an earlier state, and you can see what modifications your project members have made. You can merge and select changes. You can deal with disagreements over files. 
* 		 
* 		Serious DH projects use gits
* 		And all your project members need to use git... 
* 		 
"Git is not about being smart"
It's about knowing the process  and being a good project member. It will save you a lot of time. It should NOT be optional.

What's the difference btw Git and GitHub?
Git = command line tool that lets you work with Git repositories
GitHub is a service that stores repositories on the internet. 

If GitHub goes away, there will still be Git.

To get started: you need a GitHub account, and basic knowledge of command line. 

git --version
* 		If your version is less than 2, you should probably update it. 
* 		 

((We check our git config, create new repositories, and clone them. Then...))


git remote -v
* 		Shows the remote origin location
* 		as distinct from the local working directory
* 		 
ls -lisa
* 		shows the hidden directory curating the history of your repo
* 		You keep the complete remote history and your working history in your directory
* 		The history is kept in a hidden directory, which you can access with ls -lisa

Create a file, save it into your local working directory.

git status:
* 		notes (in red) that you have a new file. And suggests what you should do next.

git add newfile.txt
 When you add a file, you're tracking it in the (hidden) index on your local computer. You've not yet commited it to your local git repository. 
 You have to commit it, to make it part of the history of your local repository

Committing:
    you say you're happy with your work in this particular state. It's a version that you want to preserve.

git commit -m "your pithy and communicative message describing the commit"
* 		If you leave out -m

GitHub has a limit of 1 Gig on free repos. That's a GitHub limit, not a git limit.
(large projects typically split into multiple repos)

Pushing:
    git push 
* 		    pushes your commits to the remote origin.

git log
* 		shows all the commits made on the repository, starting from the local cloning as first commit

Undoing bad commits:
    git reset HEAD~
* 		    undoes the last commit, retains changes in the working directory (as uncommitteed)
    
    git reset HEAD~ --hard
* 		    undoes the last commit: removes changes from the working directory
* 		 
Mac OSX: Configuring your password on the mac keychain:
    https://help.github.com/articles/caching-your-github-password-in-git/

Pulling:
    updates your local repository with changes pushed to the remote origin
* 		git pull origin master
* 		You can also just enter "git pull" 
(What if you want to update all your repos at once, if they're all cloned into the same Workspace directory? Well, Leif says, of course you could write a for-loop to do that...)

* 		 
Python Clinic 2 (Na-Rae)
https://pittsburgh-neh-institute.github.io/Institute-Materials-2017/schedule/week_1/Python_Clinic_Day_2.html

[finished up Day 1 and moved onto Day 2]

Using regular expressions in Python
* 		import re

NOTE: Python tokenizes and handles word counts differently from the bash shell, b/c of the way Python separates punctuation into separate tokens. Expect Python's word counts to be higher. 

See Na Rae's Jupyter notebook, which she'll update and post for us later. 

 
Review (Leif and Tara)
Sorting in the Bash Shell (Leif)

Bash shell: 
sort -n -k1,2,3 field-sort.txt
If field-sort.txt is a 3-column .tsv (tab-separated values) file, you can sort based on field: k1 is first column (doesn't count from 0)
sort -n is sort numerically. Remove it if you aren't sorting integers. And if you are, and don't use -n, it'll sort 1,10, 11, 12, before 2. 20, 21...

And you can run functions in the Bash shell... (idea: Some things you do in Python can be done in Shell-ese...)


Python error messages (Tara and Leif)

* 		  On Windows, Tara tried to open that weird ISO-8859-1 text file in the inaugural collection that we had to replace, and noticed:
    If you type \ for Windows file paths, in Python, it's interpreted as an escape character. If it happens to be followed by a u, as in \u, Python interprets this as a special unicode escape code.  
    

Google Python reference (and change top menu option on page from 2.7 to 3.something:  Python Standard Library 
    https://docs.python.org/3.6/reference/index.html >> Documentation >> Library Reference
* 		has a list of all the available options.
* 		 
* 		Regular expressions in Python: https://docs.python.org/3.6/library/re.html
* 		 
Regex101.com : You can tick the box for Python regex to test expressions before running 

Stuff you can do in iPython Jupyter notebook that you can't do in regular Python:
* 		    re.findall? 
If you want to find out what a Python object does, add a ? to it, and the notebook will provide you a definition!
If you add another, ??, it gives the Python source code definition:
* 		    re.findall??
* 		 
Python error messages: look DOWN...the most important part will be at the bottom.

Name errors: misspelling the name of a function(). 

If you reopen an old notebook, and it Cell --> Run all, you may still need to go up and make sure that a cell fired properly. 

Practice Regex!
Regex Crossword Puzzles: https://regexcrossword.com/ 

Day 5 // July 14, 2017
 
How the Internet Works #2 (Tara)

127.0.0.1 >> means that the computer is using the network to talk to itself and no one else can see that
Jupyter Notebook (localhost:8888) means it is bound to port 8888 via local host

SSL
SSH
HTTPS
* 		Secure Sockets Layer: encrypts the traffic between computers 
* 		openssl command: lets you speak to a server to make an https request
* 		(if you have something like SSL access set up, you can create an alias for it in your .bashprofile )
Not invulnerable...

tcpdump
* 		from the man page: 
* 		"Tcpdump  prints  out a description of the contents of packets on a network interface that match the boolean expression"
A "man in the middle" attack: 
* 		    hackers can access the report of traffic (tcpdump)--and find ways to access the various sites reported

Want to watch a live visualization of web attacks? go to http://map.norsecorp.com/#/

Google is big on spreading the word that everyone publishing webpages should really be using https...it's getting easier and easier to do.
* 		 
Using SSH Keys with GitHub Accounts 
so you don't have to type your pwd so much, and it's harder for hackers to guess your SSH key
ssh keys start with ssh-rsa, then a long string of characters. 

saved in .ssh file, with permissions that must be set properly or it won't work

