#include "structs.h"
#include "render.h"
#include <iostream>

void drawWorldOnCanvas(PixelMatrix& canvas) {
	int H = canvas.height;
	int W = canvas.width;
	int x, y;

	Color white (255,255,255);
	Color red (255,0,0);
	Color green (50, 255, 0);
	Sphere sphere1 (Vec(W/1.5, H/1.5, 50), 100, red);
	Sphere sphere2 (Vec(W/2, H/2, 200), 50, green);
	
	// for each pixel
	for (y = 0; y < H; y++) {
		for (x = 0; x < W; x++) {
			// send a ray through each pixel (create a ray for each pixel)
			Ray ray (Vec(x,y,0), Vec(0,0,1));
			double t = 20000;

			// check for intersections
			if (sphere1.intersects(ray, t)) {
				// Color pixel
				canvas.colorPixel(x, y, sphere1.color);
			}

			std::cout << t;

			if (sphere2.intersects(ray, t)) {
				canvas.colorPixel(x, y, sphere2.color);
			}
		}
	}
}

int main() {
	const int W = 500; // canvas width
	const int H = 500; // canvas height
	PixelMatrix canvas (W, H); // our canvas to draw on

	drawWorldOnCanvas(canvas);
	renderToFile(canvas);

	return 0;
}