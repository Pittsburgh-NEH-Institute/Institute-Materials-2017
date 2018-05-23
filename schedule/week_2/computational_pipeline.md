# Edition development as a computational pipeline

## Computational pipelines and the Unix command line

A *computational pipeline* is a processing model that decomposes a large task into smaller ones that are connected, so that the output of one process becomes the input to the next. This is a familiar pattern in the Unix shell environment, where a task may be performed by chaining together small [filters](../week_1/command_2.md#filters) (programs that read from stdin and write to stdout).

Pipelining makes it possible to develop small components of a task independently from one another. For example, in the filter exercise from Week 1 mentioned above, we ran:

```bash
wc -l *.txt | sort -n | head -n 5
``` 

to extract information about the number of lines in several text files, we sorted them numerically, and we output just the top five items from the sorted list. Our output was:

```
240 NENE02018B.txt
300 NENE01729A.txt
300 NENE01729B.txt
300 NENE01736A.txt
300 NENE01751A.txt
```

which helped us find the file that had too few lines, in this case because it contained bad data. The advantage of piping the three commands together instead of writing a single *black-box* program is that we can change individual parts without affecting the others. For example, if we need to count words or characters instead of lines, we can change the first step in the pipeline (change `wc -l` to `wc - w` or `wc -c`) without modifying the rest.

## The Gothenburg model as a computational pipeline

[The Gothenburg model of textual variation](https://wiki.tei-c.org/index.php/Textual_Variance#The_.E2.80.9CGothenburg_model.E2.80.9D:_A_modular_architecture_for_computer-aided_collation) is an example of modeling a philological task (the collation and analysis of variation in manuscript witnesses) as a computational pipeline. The Gothenburg model emerged from a meeting of the developers of [CollateX](https://collatex.net) and [Juxta](http://www.juxtasoftware.org/), two systems for the collation and analysis of variation, in 2009 in Gothenburg, Sweden. The goal of the meeting was to understand textual collation as a computational pipeline, so that tools could be developed within a modular framework.

The Gothenburg model identified five stages in the pipeline to collate variant textual witnesses:

1. **Tokenization:** The texts must be divided into units (typically) words that can be compared and, eventually, aligned.
1. **Normalization:** Not all variation is philologically significant for comparison, and the Normalization stage is where the system can be instructed to ignore philologically insignificant variation when (subsequently) comparing and aligning the token produced by Tokenization.
1. **Alignment:** The token sequences of the witnesses are compared, with the goal of aligning the text in a way that groups moments of variation so that they can, for example, be recorded in a critical apparatus.
1. **Analysis:** The analysis stage refers not only to manual correction of errors in the output of the Alignment stage, but also, more importantly, to programmatic or algorithmic post-processing. In CollateX, for example, Alignment is based only on exact matches of normalized tokens, which can lead to arbitrary misalignment during the Alignment stage. At the Analysis stage, the system can apply _near matching_ (_fuzzy_ or _inexact_ matching) to align on the closest match in situations where there is no exact match.
1. **Visualization:** The Visualization stage reflects the fact that the output of collation is ultimately made available for human inspection and for further processing. This may involve literal visualization (as HTML, plain text, an SVG variant graph, etc.), or to a serialization that is intended not for direct viewing, but for further processing (e.g., as TEI-XML).

The motivation for the pipeline design of the Gothenburg model is that no step in the pipeline needs to know about the implementation details of any of the others. Each step expects input and produces output in specific formats and structures, but as long as those I/O requirements are met, it is possible to drop in a replacement for any one step without impinging on the functionality of the others. This makes it easy for users to customize Tokenization and Normalization to meet the orthographic peculiarities of their specific texts, and it also means that an improved alignment algorithm could be implemented without requiring users to change the way they interact with the system.

## The digital edition as a computational pipeline

A computational pipeline is a way of decomposing a complex problem vaguely described (e.g., “create a digital edition of Mary Shelley’s _Frankenstein_”) into a process of individual and specific steps (see, for example, the pipeline approach underlying the [Pittsburgh Frankenstein Project](https://pghfrankenstein.github.io/Pittsburgh_Frankenstein/)). Each step in a pipeline accepts input in a particular format and produces output in a particular format, but what happens within each step is self-contained, which means that they can be developed largely independently of one another. In a pipeline approach to creating a digital edition, typically the endpoints are known, that is, the input data are available in a particular format and outcome goals have been defined. The process of creating the edition then comes down to defining the steps to get from the input to the output. The level of granularity of those steps is partially a conceptual issue (what can be understood intellectually as a discrete step in a process?) and partially a practical one (what details can be implemented independently of others, as long as the input and output formats are known?). 

The computational pipeline model presupposes starting from the outcome research goals and working backward to plan how to arrive there. This means that although it may be necessary to perform markup before processing the markup, insofar as the markup, the processing, and the output of the processing are all steps in the pipeline, planning for the eventual output reduces the risk of doing the markup incorrectly, whether by omitting markup you need or spending time implementing markup you don’t need. Planning for your output in advance doesn’t mean that you can’t add new goals as the project progresses, but insofar as we build editions in order to use them in research, it ensures that development decisions will be motivated from the outset by research questions. 