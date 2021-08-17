from graphics import *

def getInputs():

#windowsize

    windowSize = int(input("Enter your window size."))

    while not (windowSize != 5 or windowSize != 7):

        print("This is not a valid window size. The valid sizes are: 5 and 7.")
        windowSize = int(input("Enter your window size."))

#colours

    valid = ["red","blue","green","magenta","orange","cyan"]
    colours = []

    while len(colours) < 3:
        colour = input("Enter your colour.")

        if (colour in valid):

            if (colour in colours):
                print("You have already chosen this colour.")
            else:
                colours.append(colour)
        else:
            print("Invalid Colour.")

    return windowSize, colours

#graphWin

def window(windowSize):

    win = GraphWin("Window :)", windowSize * 100, windowSize * 100)

    return win

#draws patch 6

def draw6(win,x,y,colour):

    list = []

    for i in range(10):
        square = Rectangle(Point(x,y),Point(x+10,y+10))
        square.setFill(colour)
        square.setOutline(colour)
        square.draw(win)
        x+=10
        y-=10
        list.append(square)
    return square

#required for patch 0

def triangleLineEven(win,x,y,colour):

    for i in range(5):
        triangle = Polygon(Point(x, y), Point(x+20, y), Point(x+10, y-20))
        triangle.draw(win)
        triangle.setFill(colour)
        x+=20

#required for patch 0

def triangleLineOdd(win, x, y, colour):

    list = []

    start = Polygon(Point(x, y), Point(x+10, y), Point(x,y-20))
    start.draw(win)
    start.setFill(colour)
    x+=10

    for i in range(4):
        triangle = Polygon(Point(x, y), Point(x+20, y), Point(x+10, y-20))
        triangle.draw(win)
        triangle.setFill(colour)
        x+=20
        list.append(triangle)

    end = Polygon(Point(x, y), Point(x+10, y), Point(x+10,y-20))
    end.draw(win)
    end.setFill(colour)

    list.append(start)
    list.append(end)
    return list
#draws patch 0

def draw0(win, x, y, colour):
    points = []
    for i in range(2):
        t1 = triangleLineEven(win, x, y, colour)
        t2 = triangleLineOdd(win, x, y-20, colour)
        y-=40
        points. extend(t1,t2)
    triangleLineEven(win, x, y, colour)
    return points
#draws patches in design

def design(win,windowSize, colours):
    points = []
    colour = ""

    for y in range(0, windowSize * 100+1, 100):

        for x in range(0, windowSize * 100+1, 100):

            if  y == -x +(windowSize*100):
                colour = colours[1]
            elif y > -x+(windowSize*100):
                colour = colours[2]
            else:
                colour = colours[0]

            if x <= (windowSize*100)-300 and y > 250:
                points.append(draw6(win, x, y, colour))
            else:
                points.append(draw0(win, x, y, colour))


def main():
    windowSize, colours = getInputs()
    win = window(windowSize)
    design(win, windowSize, colours)

main()


 click = win.getMouse()
            xCord = click.getX()
            yCord = click.getY()
            x = int(xCord / 100) * 100 # these make sure the top right of the box is always selected
            y = int(yCord / 100) * 100
x1, x2 = x2, x1

