package xmlparserdaocdb;

import org.w3c.dom.*;

public class XmlParserDAOCDB {

	/**
	 * Stampa le info sui nodi, in modo ricorsivo
	 * @param currentNode il nodo corrente
	 */
	public void printNodeInfo(Node currentNode, Item item, boolean isNew) {
		short sNodeType = currentNode.getNodeType();
		//Se è di tipo Element ricavo le informazioni e le stampo
		if (sNodeType == Node.ELEMENT_NODE) {
			String sNodeName = currentNode.getNodeName();
			String sNodeValue = searchTextInElement(currentNode);
			//NamedNodeMap nnmAttributes = currentNode.getAttributes();
//			System.out.println("Elemento: " + sNodeName);
			//System.out.println("Attributi: " + printAttributes(nnmAttributes));
//			System.out.println("Contenuto: " + sNodeValue);
			item.setter(sNodeName, sNodeValue, isNew);
		}
		int iChildNumber = currentNode.getChildNodes().getLength();
		//Se non si tratta di una foglia continua l'esplorazione 
		if (currentNode.hasChildNodes()) {
			NodeList nlChilds = currentNode.getChildNodes();
			for (int iChild = 0; iChild < iChildNumber; iChild++) {
				printNodeInfo(nlChilds.item(iChild), item, isNew);
			}
		}
	}
  
        /*
         * Search the content for a given Node
         */
        private static String searchTextInElement(Node elementNode) {
              String sText = "";
              if (elementNode.hasChildNodes()) {
                     //Il child node di tipo testo è il primo
                     Node nTextChild = elementNode.getChildNodes().item(0);
                     sText = nTextChild.getNodeValue();
              }
              return sText;
        }
  /*
        private static String printAttributes(NamedNodeMap nnm) {
              String sAttrList = new String();
              if (nnm != null && nnm.getLength() > 0) {
                     for (int iAttr=0; iAttr < nnm.getLength(); iAttr++) {
                            sAttrList += nnm.item(iAttr).getNodeName();
                            sAttrList += "=";
                            sAttrList += nnm.item(iAttr).getNodeValue();
                            sAttrList += "; ";
                     }
                     return sAttrList;
              }
              else {
                     return "assenti";
              }
        }*/
}
