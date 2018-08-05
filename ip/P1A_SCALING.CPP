#include <iostream.h>
#include <conio.h>
#include <graphics.h>

/*
A rectangle is represented by
an int array with size 4 -> a[4]

a[0] -> top-left x-coordinate
a[1] -> top-left y-coordinate
a[2] -> bottom-right x-coordinate
a[3] -> bottom-right y-coordinate

Instead of using an array, 4 separate variables
can be used but it'll increase the no. of variables
and can make the code confusing
*/

/*
Draws a rectangle with a title
1st parameter -> rectangle as array
2nd parameter -> text (can be ommitted if text is not required)
*/
void draw_rect(int r[4], const char* text)
{
	rectangle(r[0], r[1], r[2], r[3]);
	outtextxy(r[0], r[1] - 10, text); // can be ommitted if text is not required
}

/*
Translates the rectangle
1st parameter -> rectangle as array
2nd parameter -> x-component of translation factor
3nd parameter -> y-component of translation factor

Performs translation by adding x-component of translation factor
to x-components of the rectangle,
and adding y-component of translation factor
to y-components of the rectangle.
*/
int* translate_rect(int r[4], int x, int y)
{
	int tr[4];
	tr[0] = r[0] + x;
	tr[1] = r[1] + y;
	tr[2] = r[2] + x;
	tr[3] = r[3] + y;
	return tr;
}

/*
Scales the rectangle
1st parameter -> rectangle as array
2nd parameter -> scaling factor
*/
int* scale_rect(int r[4], float sf)
{
	// Create new rectangle array
	int sr[4];
	
	// Assign the top left coordinates as it is
	sr[0] = r[0];
	sr[1] = r[1];

	// Calculate width and height of rectangle
	int h = r[3] - r[1]; // y components for height
	int w = r[2] - r[0]; // x components for width

	// Calculate bottom right co-ordinates
	sr[2] = (w * sf) + r[0]; // Multiply width with scaling factor
							 // to get new width, and add top-left
							 // x-coordinate to get new x-coordinate
	sr[3] = (h * sf) + r[1]; // Multiply height with scaling factor
							 // to get new height, and add top-left
							 // x-coordinate to get new x-coordinate
	
	// Return the new rectangle
	return sr;
}

int main()
{
	// Initialize graphics mode
	int gdriver = DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TURBOC3\\BGI");
	setcolor(15);

	// Declare the variables
	int r[4]; // Input rectangle
	int* sr;  // The scaled rectangle
	float sf; // Scaling factor

	// Get rectangle coordinates and scaling factor
	cout << "Enter the original coordinates: ";
	cin >> r[0] >> r[1] >> r[2] >> r[3];
	cout << "Enter the scaling factor: ";
	cin >> sf;

	// Draw the input rectangle
	draw_rect(r, "Original rectangle");

	// Scale the rectangle
	sr = scale_rect(r, sf);
	// translate to avoid overlapping with original rectangle
	sr = translate_rect(sr, 300, 0);
	// Draw the scaled rectangle
	draw_rect(sr, "Scaled rectangle");

	// Wait for keypress and close graphics mode
	getch();
	closegraph();
	return 0;
}
