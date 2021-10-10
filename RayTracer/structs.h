#include <cmath>
#include <vector>

#ifndef STRUCTS_H
#define STRUCTS_H

struct Color {
	double r,g,b;
	Color() {r=g=b=0;}
	Color(double d1, double d2, double d3) {r = d1, g = d2, b = d3;}
};

struct PixelMatrix {
	std::vector< std::vector<Color> > matrix;
	int width, height;

	PixelMatrix(int H, int W) {
		width = W;
		height = H;
		Color black (0,0,0);
		std::vector<Color> row (W, black);
		matrix.resize(H, row);
	}

	void colorPixel(int x, int y, Color color) {
		matrix[x][y] = color;
	}
};


struct Vec {
	double x, y, z;
	Vec() {x = y = z = 0;}
	Vec(double a, double b, double c) {x = a, y = b, z = c;}
	Vec operator + (Vec v) {return Vec(x+v.x, y+v.y, z+v.z);}
	Vec operator - (Vec v) {return Vec(x-v.x, y-v.y, z-v.z);}
	double operator * (Vec v) {return (v.x*x+v.y*y+v.z*z);} // dot product
	Vec operator *= (Vec v) {return Vec (y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x);} // vector multiplication
};

struct Ray {
	Vec o; // origin
	Vec d; // direction
	Ray(Vec v1, Vec v2) {o = v1, d = v2;}
};

struct Sphere {
	Vec C; // center (Stützvektor)
	double r; // radius
	Color color;
	Sphere(Vec V, double rad, Color c) {C = V, r = rad, color = c;}
	bool intersects(Ray ray, double& t) {
		Vec O = ray.o;
		Vec D = ray.d;
		Vec OC = O - C;
		double v = OC * D; // project OC onto D
		double disc = r*r - (OC*OC - v*v);
		if (disc < 0) return false;
		else {
			// sphere intersects ray
			double d = sqrt(disc);
			t = v - d; // distance at wich ray intersects sphere
			
			return true;
		}
	}
};

#endif