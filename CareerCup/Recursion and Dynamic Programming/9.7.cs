// Implement the "paint fill" function that one might see on many image editing programs.
// That is given a screen (represented by a 2d array of colors) a point, and a new color, fill in the 
// Surrounding area unitl the color changes from the original color to the new color. 

//Q - what are the limits of the size of this 2d array - 1000 x 1000
//Q - how would u like me to store colors - enum
public enum color
{
    BLACK,
    WHITE,
    YELLOW,
    BLUE,
    GREEN
}
public class Program
{

    public color[,] Paint(color[,] canvas, int x, int y, color newColor)
    {


        color fillAreaColor = canvas[x, y];
        if (fillAreaColor == newColor)
        {
            return canvas;
        }

        Fill(canvas, x, y, newColor, fillAreaColor);
        return canvas;
    }

    public void Fill(color[,] canvas, int x, int y, color newColor, color fillAreaColor)
    {
        if (x >= canvas.GetLength(0) || y >= canvas.GetLength(1) || x < 0 || y < 0)
        {
            return;

        }

        color currPixelColor = canvas[x, y];

        if (currPixelColor != fillAreaColor)
        {
            return;
        }
        else
        {
            //fill
            canvas[x, y] = newColor;
        }
    
        Fill(canvas, x - 1, y, newColor, fillAreaColor);
        Fill(canvas, x + 1, y, newColor, fillAreaColor);
        Fill(canvas, x, y - 1, newColor, fillAreaColor);
        Fill(canvas, x, y + 1, newColor, fillAreaColor);


    }

}