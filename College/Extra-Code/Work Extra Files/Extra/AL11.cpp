#include <iostream>
#include <fstream>
#include <iomanip>
#include <cmath>
#include <array>
using namespace std;

# define MAX 50 // maximum size of array of Record

// structure for storing student details
// each student has a student id and 3 test scores
// additional field for average score and letter grade
struct Record
{
	string student_id; // This was an int
	double scores[5]; // This is wrong. What happens to be more grades than this
	double avgScore;
	char letterGrade;
};

// function declaration
void displayRecords(Record records[], int n);
void computeAverage(Record records[], int n);
void computeLetterGrade(Record records[], int n);
double computeClassAverage(Record records[], int n);
double computeClassStandardDeviation(Record records[], int n);
void displayClassAvgSD(Record records[], int n);

int main() {
	Record records[5];
	const int NG = 4;
	string names[] = { "Amy Adams", "Bob Barr", "Carla Carr",
					  "Dan Dobbs", "Elena Evans"
	};
	int n = sizeof(names) / 28;
	int exams[][NG] = { {98,87,93,88},
						{78,86,82,91},
						{66,71,85,94},
						{72,63,77,69},
						{91,83,76,60}
	};

	for (int i = 0; i < n; i++) { // Assign Scores
		for (int j = 0; j<  NG; j++) {
			records[i].scores[j] = exams[i][j];
		}
	}

	for (int i = 0; i < n; i++) { // Assign Students names
		records[i].student_id = names[i]; // Assign name to each student
	}

	// compute and populate average and letter grade
	computeAverage(records, n);
	computeLetterGrade(records, n);
	// display student records
	displayRecords(records, n);
	// compute and display class average and standard deviation
	displayClassAvgSD(records, n);
	return 0;
}

// function to display the details of student in a tabular format
// records is the array of students
// n - number of students
void displayRecords(Record records[], int n)
{
	cout << left << setw(15) << "Student id" << right << setw(10) << "Score 1" << right << setw(10) << "Score 2" << right << setw(10) << "Score 3" << right << setw(15) << "Average Score"
		<< right << setw(15) << "Letter Grade" << endl;

	cout << fixed << setprecision(2);
	for (int i = 0; i < n; i++)
	{
		cout << left << setw(15) << records[i].student_id << right << setw(10) << records[i].scores[0] << right << setw(10) << records[i].scores[1] << right << setw(10) << records[i].scores[2]
			<< right << setw(10) << records[i].avgScore << right << setw(12) << records[i].letterGrade << endl;
	}
	cout << endl;
}

// function to compute average of each student in the records
// records is the array of students
// n - number of students
void computeAverage(Record records[], int n)
{
	// loop over the number of students computing and populating average of each student
	for (int i = 0; i < n; i++)
	{
		records[i].avgScore = 0;
		for (int j = 0; j < 3; j++)
			records[i].avgScore += records[i].scores[j];
		records[i].avgScore = records[i].avgScore / 3;
	}
}

// function to compute and populate letter grade for each student in the records
// records is the array of students
// n - number of students
void computeLetterGrade(Record records[], int n)
{
	// loop over the array populating letter grade of each student
	for (int i = 0; i < n; i++)
	{
		if (records[i].avgScore >= 90)
			records[i].letterGrade = 'A';
		else if (records[i].avgScore >= 80)
			records[i].letterGrade = 'B';
		else if (records[i].avgScore >= 65)
			records[i].letterGrade = 'C';
		else if (records[i].avgScore >= 50)
			records[i].letterGrade = 'D';
		else
			records[i].letterGrade = 'F';
	}
}

// function to compute and return the class average
// records is the array of students
// n - number of students
double computeClassAverage(Record records[], int n)
{
	if (n <= 0)
		return 0;
	double avg = 0;
	// loop over the array computing total average score for the class
	for (int i = 0; i < n; i++)
		avg += records[i].avgScore;

	avg = avg / n; // calculate class average
	return avg;
}

// function to compute and return the class standard deviation
// records is the array of students
// n - number of students
double computeClassStandardDeviation(Record records[], int n)
{
	if (n <= 0)
		return 0;
	// get the class average
	double avg = computeClassAverage(records, n);
	double sd = 0;
	// calculate class standard deviation
	for (int i = 0; i < n; i++)
		sd += pow(avg - records[i].avgScore, 2);

	sd = sqrt(sd / n);

	return sd;
}

// function to display the class average and standard deviation
// records is the array of students
// n - number of students
void displayClassAvgSD(Record records[], int n)
{
	double avg = computeClassAverage(records, n); // get the class average
	double sd = computeClassStandardDeviation(records, n); // get the class standard deviation
	// display the average and standard deviation
	cout << fixed << setprecision(2);
	cout << "Class Average : " << avg << endl;
	cout << "Class Standard Deviation : " << sd << endl;
}
//end of program
