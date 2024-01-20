package navigation

import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.utils.material3.AppyxMaterial3NavNode

private val navItems = NavItem.entries.toList()
class RootNode(
    buildContext: BuildContext,
) : AppyxMaterial3NavNode<NavItem>(
    buildContext = buildContext,
    navTargets = navItems,
    navTargetResolver = NavItem.resolver
)