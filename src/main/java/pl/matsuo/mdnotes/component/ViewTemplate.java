package pl.matsuo.mdnotes.component;

import static j2html.TagCreator.a;
import static j2html.TagCreator.attrs;
import static j2html.TagCreator.b;
import static j2html.TagCreator.div;
import static j2html.TagCreator.each;
import static j2html.TagCreator.li;
import static j2html.TagCreator.ol;
import static j2html.TagCreator.span;
import static pl.matsuo.core.util.collection.Pair.pair;
import static pl.matsuo.core.util.desktop.BootstrapIcons.file_plus;
import static pl.matsuo.core.util.desktop.BootstrapIcons.folder_plus;
import static pl.matsuo.core.util.desktop.BootstrapIcons.gear;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;
import lombok.RequiredArgsConstructor;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.core.util.desktop.component.FormComponents;
import pl.matsuo.core.util.desktop.component.ViewComponents;
import pl.matsuo.mdnotes.model.Folder;
import pl.matsuo.mdnotes.model.MdNotesModel;

@RequiredArgsConstructor
public class ViewTemplate {

  final ViewComponents viewComponents;
  final FormComponents forms;

  public ContainerTag view(IRequest request, MdNotesModel model, DomContent content) {
    return viewComponents.pageTemplate(
        "Markdown Notes",
        div(
            attrs(".row"),
            div(
                attrs(".col-2.border-right.bg-light.left-bar.file-listing"),
                fileListing(model.getRoot(), ""),
                div(
                    attrs(".toolbar.pt-3.pb-3.text-right"),
                    forms.formAsLink(file_plus.svg("mr-3"), "/files/add"),
                    forms.formAsLink(folder_plus.svg("mr-3"), "/folders/add"))),
            div(attrs(".col-10.left-bar"), content, div(attrs(".toolbar.pt-3.pb-3"), gear.svg()))));
  }

  private ContainerTag fileListing(Folder root, String baseDir) {
    return ol(
        attrs(".list-unstyled"),
        each(
            root.getFolders(),
            (key, value) ->
                li(
                    forms.formAsLink(
                        b(key), "/folders/toggle", pair("name", fileName(baseDir, key))),
                    value.isExpanded() ? fileListing(value, fileName(baseDir, key)) : span())),
        each(
            root.getFiles(),
            (key, value) -> li(a(key).withHref("/?name=" + fileName(baseDir, key)))));
  }

  public static String fileName(String baseDir, String key) {
    return baseDir.isEmpty() ? key : baseDir + "/" + key;
  }
}
