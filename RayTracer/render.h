#include "structs.h"
#include <fstream>

#ifndef RENDER_H
#define RENDER_H

void renderToFile(PixelMatrix canvas) {
	int H = canvas.height;
	int W = canvas.width;
	int x, y;

	std::ofstream out ("out.ppm"); // generate image file and stream
	out << "P3\n" << W << '\n' << H << '\n' << "255\n";

	for (y = 0; y < H; ++y) {
		for (x = 0; x < W; ++x) {
			Color& clr = canvas.matrix[y][x];
			out << clr.r << std::endl;
			out << clr.g << std::endl;
			out << clr.b << std::endl;
		}
	}
}

#endif