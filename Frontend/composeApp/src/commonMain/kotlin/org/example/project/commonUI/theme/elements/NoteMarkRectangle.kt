package org.example.project.commonUI.theme.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import org.example.project.commonUI.theme.insideRectangle
import org.example.project.commonUI.theme.outsideRectangle

@Composable
fun NoteMarkRectangle(
    rotationDegrees : Float,
    canvasHeight : Float,
    outsideScaleWidth : Float = 1f,
    outsideScaleHeight : Float = 1f,
    insideScaleWidth : Float = 1f,
    insideScaleHeight : Float = 1f,
    outsideOffsetWidth : Float = 1f,
    outsideOffsetHeight : Float = 1f,
    insideOffsetWidth : Float = 1f,
    insideOffsetHeight : Float = 1f,
    modifier : Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(canvasHeight.dp)
            .drawBehind{
                rotate(degrees=rotationDegrees){
                    drawRect(
                        color = outsideRectangle,
                        topLeft = Offset(size.width * outsideOffsetWidth, size.height * outsideOffsetHeight),
                        size = Size(size.width * outsideScaleWidth, size.height * outsideScaleHeight)

                    )
                }
            }
    ){
        Canvas(modifier = Modifier.fillMaxWidth().height(canvasHeight.dp)){
            rotate(degrees=rotationDegrees){
                drawRect(
                    color = insideRectangle,
                    topLeft = Offset(size.width * insideOffsetWidth, size.height * insideOffsetHeight),
                    size = Size(size.width * insideScaleWidth, size.height * insideScaleHeight)
                )
            }
        }
    }
}