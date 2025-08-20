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
