# queues

This program receives a JSON via stdin containing:

- new_agent: Agents of the company and their primary and secondary skills
- new_job: Available jobs to be done in the company and its type
- job_request: Requests done by idle agents, searching for available jobs that match their skills

Then, jobs are assigned to idle agents, following the logic that the agent must have the job type as his
primary or secondary skill. Also, jobs marked as urgent have priority over not urgent jobs.

The program then returns via stdout the assignments that were made, containing:

- job_id: The ID of the assigned job
- agent_id: The ID of the agent to whom the job was assigned

## Usage

Please make sure to have Java installed.

### Obtaining the jar

If you don't have Leiningen installed:

1. Download here the jar **queues-0.1.0-SNAPSHOT-standalone.jar**

If you have Leiningen installed:

1. Download this project
2. In the project folder, compile it:
 
```
lein compile
```

3. Generate the jar:

```
lein uberjar
```

The jar **queues-0.1.0-SNAPSHOT-standalone.jar** will be available inside the _target_ folder

### Running the jar

With this program, you can provide the input JSON as a .txt file or by typing it in the
command prompt.
If you want to provide the file, please make sure to have the file in the same folder as
the jar, to make things easier.

1. At the command prompt, execute:

```
java -jar queues-0.1.0-SNAPSHOT-standalone.jar
```

The following text will appear:


#### Providing the file

2. Type "1" and enter
3. Provide the name of the file that contains the input JSON.
Here in the project I provided the file resources/stdin1.txt for your
commodity :)

Your screen should look like:

<img src="resources/providingfile.PNG"
title="Providing the file"/>

#### Typing the JSON content
2. Type "2" and enter
3. Type or paste the content of the JSON file
4. Type ":done" and enter when finished

Your screen should look like:

<img src="resources/providingtext.png"
title="Providing the text"/>
