# Language Trainer
This software is intended to be used as a German language learning resource for English speakers. 


## Build status
The student can choose between differnet learning tasks:
- [x] Vocabulary 
- [x] Reading and understanding text
- [ ] Grammar

For now the programm runs as a console application.

## How the classes interact
The detailed attributes and methods are shown in following UML, it followes a short description for each class.




#### CSVScanner
The CSVScanner handels everything concerning reading, writing and deleting CSV files.
During training two CSV-Files are created or updated to preserve the study progress.

#### VocTrainer
The VocTrainer-Class handels everything concerned with the training of vocabulary. 
The Trainer "trains" with the train method but distinguishes between the very first training, training of known or training of unknown words. 
Depending on which mode is chosen by the user the different csv files are scanned and according to the knowledge of the student saved after training. 

#### ReadingTrainer
The ReadingTrainer-Class provides and displays the Texts and the accompanying questions and checks the correctnes of the given answers.

#### Questions
The Questions-Class provides the questions to each text. 

#### Texts
In the Text-Class new Texts can be added and formated.

#### TextWithQuestions
This Class combines the texts with the affiliated questions. 



## How to update or add learning content
All needed files are in the "resources" folder.
To add new vocabulary the there saved CSV file "voc_list" can be updatet, to add questions the "questions_for_text" file can be upatet.
Text are saved in a seperate Text-Class to simplify the representation in the console.
All new CSV files which are written (f.ex list of known vocabulary a.s.o) are saved to the exact same folder.
Direction and Filenames can quickly be changed in the Main file. 
