# OOP, Maven and Developer Practices - Day 3

## Linux File Commands Using GitBash

Below are some useful UNIX/Linux commands for handling files using GitBash. Always remember that UNIX/Linux commands are case-sensitive.

`ls`

- Lists all files and directories in the current directory.
- Some versions may support color coding to differentiate file types.
- `ls -l | more`: Lists files in long format, pausing after each screenful of information.
- `ls -l`: Lists files in long format, showing detailed information like permissions, owner, size, and modification date.

---

`cd`

- Changes the current directory.
- `cd ..`: Moves up one directory level.
- `cd /path/to/directory`: Navigates to a specific directory.

---

`pwd`

- Prints the current working directory.

---

`mkdir`

- Creates a new directory.
- `mkdir new_directory`: Creates a directory named "new_directory".

---

`cat`

- Concatenates and displays file content.
- `cat file.txt`: Displays the content of "file.txt".
- `cat file1.txt file2.txt > combined.txt`: Combines "file1.txt" and "file2.txt" into "combined.txt".
- `cat > file.txt`: Creates a new file "file.txt" and allows you to input text until you press `CTRL+D` to save and exit.

When you type in the the command above, the command prompt will disappear. This is because of the `>` (greater than) symbol, which is known as "output redirection".
At this point the keyboard is being re-directed into the new file. You can type in whatever you want, and when you are done, press `CTRL+D` to save the file and return to the command prompt.

Another way to create a file using `cat`:

`cat sourcefilename > destinationfilename`: Copies the content of "sourcefilename" into "destinationfilename".

---

`touch`

- Creates a new empty file.
- `touch newfile.txt`: Creates an empty file named "newfile.txt".
- From here you can use a terminal based text editor like `nano` or `vim` to edit the file.

---

`echo`

- Displays a line of text or a variable value.
- `echo "Hello, World!"`: Prints "Hello, World!" to the terminal.
- `echo $VARIABLE_NAME`: Prints the value of the environment variable "VARIABLE_NAME".
- Strings that are passed to `echo` can also be redirected into a file using the `>` operator: `echo "This is a test" > testfile.txt`

---

`grep`

- Searches for a specific pattern in files.
- `grep "search_term" file.txt`: Searches for "search_term" in "file.txt".
- `grep -r "search_term" /path/to/directory`: Recursively searches for "search_term" in all files within the specified directory.

---

`diff`

- Compares the contents of two files line by line.
- `diff file1.txt file2.txt`: Displays the differences between "file1.txt" and "file2.txt".
- The output will be formatted to show lines that are different, with `<` indicating lines from the first file and `>` indicating lines from the second file.

### Real World Application

**Why Use the Command Line?**

It is important to know why using the command line is crucial:

- When Unix was developed, there was no graphical user interface (GUI), so all interactions were done through the command line.
  - Command-line interfaces (CLI) were natural for this type of terminal. The use of text terminals was also a major reason why Unix developers preferred short command names, as they were faster to type.
- Programming tools use the command line to perform tasks.
  - Programmers have been the staunchest advocates of Linux because it has so many tools for them to get their work done: interpreters, compilers, debuggers, and more. And these tools are often used through the command line.
  - While you can use all of these tools from a graphical IDE, it is just a front-end to the command line.
- The command line is faster than a GUI.
  - For many tasks, using the command line is much faster than using a graphical interface. This is especially true for repetitive tasks, where you can write scripts to automate processes.
  - Command-line programs start faster than graphical ones because there's less overhead.
- The command line works everywhere, including on servers.
  - One of the main reasons why Linux is so popular for servers is that it can be managed entirely through the command line.
  - One big reason why the command line has survived on Linux systems is that it works just about everywhere.
- The command line is scriptable.
  - You can write scripts to automate tasks using shell scripting languages like Bash. This allows for complex workflows to be executed with a single command.
  - For example, if you wanted to copy all your text files to a directory, you'd use this line: `cp *.txt /path/to/directory`
  - A script could be written if you wanted to do this repeatedly, which would save time and reduce errors.

## Moving and Deleting Files Using GitBash

Below are some useful UNIX/Linux commands for moving and deleting files using GitBash. Always remember that UNIX/Linux commands are case-sensitive.

`mv`

The `mv` command moves a file or renames it. It can also be used to move files between directories.

`mv file1 directory1`: Moves "file1" into "directory1".
`mv file1 file2 file3 directory1`: Moves "file1", "file2", and "file3" into "directory1".
`mv -i file1 directory1`: Moves "file1" into "directory1", prompting for confirmation if the destination file already exists.
`mv -n file1 directory1`: Moves "file1" into "directory1", but does not overwrite an existing file in the destination.
`mv -u file1 directory1`: Moves "file1" into "directory1" only if "file1" is newer than the existing file in the destination.
`mv -b file1 directory1`: Moves "file1" into "directory1", creating a backup of the destination file if it exists.

---

`cp`

The `cp` command copies files and directories.

`cp second.txt third.txt`: Copies "second.txt" to "third.txt".
`cp -i second.txt third.txt`: Copies "second.txt" to "third.txt", prompting for confirmation if "third.txt" already exists.
`cp -b second.txt third.txt`: Copies "second.txt" to "third.txt", creating a backup of "third.txt" if it exists.
`cp -f second.txt third.txt`: Copies "second.txt" to "third.txt", forcing the copy even if "third.txt" is write-protected.
`cp -r directory1 directory2`: Recursively copies "directory1" and its contents to "directory2".
`cp -p second.txt third.txt`: Copies "second.txt" to "third.txt", preserving the original file's attributes (permissions, timestamps, etc.).

---

`rm`

The `rm` command removes files or directories.

`rm file1`: Deletes "file1".
`rm -i file1`: Prompts for confirmation before deleting "file1".
`rm -r directory1`: Recursively deletes "directory1" and its contents.
`rm -f file1`: Forces the deletion of "file1" without prompting for confirmation.

### Real World Application

**Advantages of Using Command Line Interface (CLI)**

When using a command-line interface, you can use detailed commands more efficiently and faster than you can with a graphical user interface (GUI). It demonstrates the advantages of using a command-line interface in this case, as it can handle extremely repetitive tasks across a wide range of systems.

With the assistance of a program like the computer CLI or code, it is easier for the user to control everything. The user's interface is slow when they navigate through different icons. This enables CLI to operate more quickly as commands are directly delivered to the computer. CLI is preferred by many professionals due to its speed and performance.

All options and operations are invoked in consistent form, while with GUIs similar operations often appear on different menus with different interfaces and different applications have different approaches.

CLIs double as scripting languages (see shell scripting), meaning that is it no more difficult to perform a rare operation than a common one. In fact, it is often easier to perform rare operations in a CLI than in a GUI, as the user can write scripts to automate those tasks. Once an operation is analyzed, it can be saved in a script and consistently performed without further effort. With GUIs, users must start over at the beginning every time, as GUI scripting is more limited (and often nonexistent). Simple commands do not even need a script, as the completed command can usually be assigned a name and executed by simply typing that name.

## Root Directories

`/bin`: Contains essential binary executables (programs) needed for system operation, such as basic commands like `ls`, `cp`, and `mv`.

`/boot`: Contains files necessary for the booting process, including the Linux kernel and initial RAM disk image.

`/dev`: Contains device files that represent hardware devices, such as hard drives, USB devices, and terminals.

`/etc`: Contains system-wide configuration files and scripts that control the behavior of various programs and services.

`/home`: Contains user home directories, where personal files and settings are stored for each user. Sometimes these are in `/usr` instead.

`/lib`: Contains shared libraries and kernel modules required by programs and the system.

`/media`: A mount point for removable media such as USB drives, CDs, and DVDs.

`/mnt`: A temporary mount point for filesystems that are mounted manually by the system administrator.

`/opt`: Contains optional software packages and third-party applications that are not part of the core system.

`/proc`: A virtual filesystem that provides information about running processes and system information. It is dynamically generated by the kernel.

`/root`: The home directory for the root user (the superuser with administrative privileges).

`/run`: A temporary filesystem that stores runtime data for processes and services. It is typically cleared on reboot.

`/sbin`: Contains essential system binaries (programs) used for system administration tasks, such as `fsck`, `reboot`, and `ifconfig`.

`/srv`: Contains data for services provided by the system, such as web server files or FTP server files.

`/sys`: A virtual filesystem that provides information about devices, drivers, and kernel subsystems. It is dynamically generated by the kernel.

`/tmp`: A temporary directory used for storing temporary files created by programs. It is typically cleared on reboot.

`/usr`: Contains user-related programs and data. It is further divided into subdirectories like `/usr/bin` (user binaries), `/usr/lib` (user libraries), and `/usr/share` (shared data).

`/var`: Contains variable data files, such as log files, mail spools, and temporary files created by programs.

## Source Control Management (git, vcs, cvcs, dvcs)

Source control management (SCM) systems are essential tools for developers, allowing them to track changes to code, collaborate with others, and manage different versions of their projects.

- **Version Control Systems (VCS)**: These systems track changes to files over time, allowing developers to revert to previous versions, compare changes, and collaborate with others. Examples include Git, Subversion (SVN), and Mercurial.

Version control is a process to manage a collection of source code and changes that provide you with many capabilities:

- Maintain multiple versions of the code.
- Ability to revert to previous versions.
- Developers can work concurrently on the same codebase.
- Audit traceability of changes with clear history on whom, which, when, where, and what was changed.
- Copy/Merge/Undo changes.
- Find out the difference between two versions of the code.
- Provides full backup without occupying additional space.
- Review history of changes.
- Capable for both small and large scale projects.

In simpler words, a Version Control System (VCS) is a system that allows developers to track changes in their code over time. It helps them collaborate, manage different versions of their projects, and revert to previous states if needed.

#### Importance of Version Control Systems

Let's take an example of an organization with a project team of five developers.

Two of the developers are in one location and the other three are in a different location. They received a project and started developing the code, and then come across the following situations:

- Each developer is working on one module at a time whereas others were waiting for developers to complete their tasks so that they can start working on their modules.
- Whenever they completed their work and decided to deploy the code, they were each taking a full backup of the project and one day they could not do it because the disk space was full.
- One day one of them deleted on module which they could not bring back and had to recreate it from scratch.
- They were unable to find out who has done what changes in the code.
- They could not do any experiments for the new feature without interfering with other developers' work.
- They need to send the code via email as they were seated in different locations, which led to confusion and version mismatches.

These situations highlight the need for a Version Control System (VCS). A VCS would allow developers to:

- A version control system ensures that all the previous versions of the code can be retrieved later on and all changes are tracked, providing a clear history of who made changes, when, and why.
- It also explains what a file looked like on a specific date or at a specific point in time.
- A version control system provides a central repository where all developers can access the latest code, reducing the need for email exchanges and preventing version mismatches and the ability to work concurrently on the same codebase.

#### Types of Version Control Systems

There are two types of Version Control Systems:

- **Centralized Version Control Systems (CVCS)**: In a CVCS, there is a single central repository that stores all versions of the code. Developers check out files from this central repository, make changes, and then check them back in. This model can lead to bottlenecks and conflicts if multiple developers are working on the same files simultaneously.

- **Distributed Version Control Systems (DVCS)**: In a DVCS, each developer has a complete copy of the repository, including its entire history. This allows for more flexible workflows, as developers can work offline, create branches, and merge changes more easily. Git is a popular example of a DVCS.

### Real World Application

#### Benefits of Version Control Systems

A version control system works as a database for your code and makes revisions instead of duplicating the entire codebase which helps to save space.

- It keeps all the history of all the files, which gives you full traceability and auditability of what changes were made, when, and by whom.
- It provides the ability to revert back to a previous version of the code if something goes wrong.
- It prevents the risk of losing work due to accidental deletions or overwrites.
- It helps to identify the differences between two versions of a file, making it easier to understand what has changed.
- It provides you with the ability to have entirely independent code versions through branching and merging.
- It provides the ability to work as a distributed team, allowing developers to work on the same codebase without interfering with each other's work.
