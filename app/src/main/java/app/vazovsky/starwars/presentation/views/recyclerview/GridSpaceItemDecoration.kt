package app.vazovsky.starwars.presentation.views.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Декоратор для GridLayoutManager
 * @param spanCount количество столбцов/строк
 * @param spacing отступ
 * @param includeEdge рисовать, включая края
 * @param excludeTopEdge исключить верхний край
 */
class GridSpaceItemDecoration(
    private val spanCount: Int,
    private val spacing: Int,
    private val includeEdge: Boolean,
    private val excludeTopEdge: Boolean,
) : RecyclerView.ItemDecoration() {

    private var orientation = -1

    companion object {
        private const val VERTICAL = RecyclerView.VERTICAL
        private const val HORIZONTAL = RecyclerView.HORIZONTAL
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view) // item position
        val spanCountPos = spanCount / ((parent.adapter as? RecyclerViewAdapterWithCustomSpanSize)?.getSpanSize(position) ?: 1)
        val column = position % spanCountPos // item column
        if (orientation == -1) orientation = getOrientation(parent)

        if (includeEdge) {
            if (orientation == VERTICAL) {
                outRect.left = spacing - column * spacing / spanCountPos
            } else {
                if (column == 0) {
                    if (!excludeTopEdge) {
                        outRect.top = spacing - column * spacing / spanCountPos
                    }
                } else {
                    outRect.top = spacing - column * spacing / spanCountPos
                }
            }
            if (orientation == VERTICAL) {
                outRect.right = (column + 1) * spacing / spanCountPos
            } else {
                outRect.bottom = (column + 1) * spacing / spanCountPos
            }

            // topWindowInsets edge
            if (position < spanCountPos) {
                if (orientation == VERTICAL) {
                    if (!excludeTopEdge) {
                        outRect.top = spacing
                    }
                } else {
                    outRect.left = spacing
                }
            }
            // item bottomWindowInsets
            if (orientation == VERTICAL) {
                outRect.bottom = spacing
            } else {
                outRect.right = spacing
            }
        } else {
            if (orientation == VERTICAL) {
                outRect.left = column * spacing / spanCountPos
            } else {
                outRect.top = column * spacing / spanCountPos
            }
            if (orientation == VERTICAL) {
                outRect.right = spacing - (column + 1) * spacing / spanCountPos
            } else {
                outRect.bottom = spacing - (column + 1) * spacing / spanCountPos
            }
            if (position >= spanCountPos) {
                // item topWindowInsets
                if (orientation == VERTICAL) {
                    outRect.top = spacing
                } else {
                    outRect.left = spacing
                }
            }
        }
    }

    private fun getOrientation(parent: RecyclerView): Int {
        return when (parent.layoutManager) {
            is GridLayoutManager -> (parent.layoutManager as GridLayoutManager).orientation
            else -> throw IllegalStateException("GridSpacingItemDecoration can only be used with a GridLayoutManager.")
        }
    }

}