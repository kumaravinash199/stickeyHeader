# stickeyHeader

It's an example of Sticky header without library. In the above example list is made sticky on top of view by using item decoration and set to recyclerview.

In onDrawOver method of RecyclerView.ItemDecoration get the very first (top) item that is visible to the user.
    View topChild = parent.getChildAt(0);

Draw the appropriate header on top of the RecyclerView by using drawHeader() method. Then upcoming header meets the top child and coming header gently pushes the top current header out of the view and takes his place eventually.
