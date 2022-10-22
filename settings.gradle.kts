rootProject.name = "kotlinStudy"

include("kopring")
include("persistence")

fun setProject(project: ProjectDescriptor) {
    project.name = project.path.substringAfterLast(":")
    project.projectDir = file("modules/${project.path.replace(":", "/")}")
}

fun updateProjectNames(project: ProjectDescriptor) {
    when (project.children.size) {
        0 -> setProject(project)
        else -> {
            project.children.forEach { updateProjectNames(it) }
            if (project.parent != null) setProject(project)
        }
    }
}

updateProjectNames(rootProject)