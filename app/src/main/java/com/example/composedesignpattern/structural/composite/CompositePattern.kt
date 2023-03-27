package com.example.composedesignpattern.structural.composite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun CompositeScreen() {
    val root = TreeBranch("목차")
    populateTree(
        root,
        listOf(
            TreeBranch("주제1") to listOf("소주제1", "소주제2"),
            TreeBranch("주제2") to listOf("소주제1", "소주제2")
        ),
        mapOf("소주제1" to listOf("1", "2"), "소주제2" to listOf("1"))
    )
    root.render()
}

interface TreeComponent {
    @Composable
    fun render()
}

class TreeNode(private val title: String) : TreeComponent {
    @Composable
    override fun render() {
        Text(text = title)
    }
}

class TreeBranch(private val title: String) : TreeComponent {

    private val children = mutableListOf<TreeComponent>()
    fun add(component: TreeComponent) {
        children.add(component)
    }

    fun remove(component: TreeComponent) {
        children.remove(component)
    }

    @Composable
    override fun render() {
        Column {
            Text(text = title, fontWeight = FontWeight.Bold)

            children.forEach { child ->
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    child.render()
                }
            }
        }
    }
}


fun populateTree(
    root: TreeBranch,
    topics: List<Pair<TreeBranch, List<String>>>,
    subTopicNodes: Map<String, List<String>>
) {
    for ((topic, subTopicTitles) in topics) {
        for (title in subTopicTitles) {
            val subTopic = TreeBranch(title)
            subTopicNodes[title]?.forEach { node ->
                subTopic.add(TreeNode(node))
            }
            topic.add(subTopic)
        }
        root.add(topic)
    }
}