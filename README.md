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

## The solution

**stdin.clj** is responsible for dealing with the JSON via stdin (as a file or plain text) and parsing it to
a map. E.g., The JSON [{"a":"1"}] becomes the map [{:a "1"}]

**sequences.clj** is responsible for dealing with sequences, like filtering the JSON map by key
(e.g. filtering the agents by getting only :new_agent keys) and getting only the values of a map

**entities.clj** deals with business entities: with the given JSON map, it gets only agents that are
idle, by crossing information from agents map and requests map, it separates jobs by priority (urgent/
not urgent) and it's also responsible for the assignment of jobs itself.

This assignment is done by getting the jobs to be done. Then, it checks if any idle agent has the job
type as a primary skill.

If any agent is found, the job is assigned to this agent and both job and agent are removed from 
available jobs and available agents maps, respectively.

If no agent has the job type as a primary skill, it checks if any idle agent has it as a secondary skill.

If any agent is found, the job is assigned to this agent and the process is the same as above.

If no agent has the job type neither as primary nor secondary skills, the job is kept in the remain
jobs map, since no agent was assigned to it.

**core.clj** contains the user interface and the main function of the program, which receives the input
JSON and outputs the response JSON.

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

```
Hi there!
This program will receive your JSON containing agents, jobs and requests and will return
    the assignments made between jobs and agents.

    First, you need to tell me if you want to give me the JSON as:

    - [1] The name of the file that contains the JSON itself

    - [2] Plain text written here on the stdin

    Please, select one of the options
```

Now you have two options:

- To provide the JSON as a file
- To input the JSON content yourself

Both ways are explained here.

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
